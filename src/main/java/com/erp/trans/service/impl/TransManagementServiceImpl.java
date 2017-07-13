package com.erp.trans.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.trans.common.constant.CustomConst;
import com.erp.trans.common.constant.CustomConst.ConsignFstate;
import com.erp.trans.common.entity.Pager;
import com.erp.trans.common.exception.ValidationException;
import com.erp.trans.common.service.impl.BaseService;
import com.erp.trans.common.util.IdentifieUtil;
import com.erp.trans.common.util.LocalCollectionUtils;
import com.erp.trans.common.util.LocalCollectionUtils.Processer;
import com.erp.trans.dao.ChargeInfoMapper;
import com.erp.trans.dao.ConsignDetailMapper;
import com.erp.trans.dao.ConsignMapper;
import com.erp.trans.dao.DespatchPlanMapper;
import com.erp.trans.dao.DesplanConnoMapper;
import com.erp.trans.entity.Consign;
import com.erp.trans.entity.ConsignDetail;
import com.erp.trans.entity.DespatchPlan;
import com.erp.trans.entity.RecordInfo;
import com.erp.trans.entity.UserInfo;
import com.erp.trans.service.TransManagementService;
import com.erp.trans.web.dto.ConsignDto;

@Service
public class TransManagementServiceImpl  extends BaseService implements TransManagementService {

	@Autowired
	ConsignMapper consignMapper;
	@Autowired
	ConsignDetailMapper consignDetailMapper;
	@Autowired
	DesplanConnoMapper desplanConnoMapper;
	@Autowired
	DespatchPlanMapper despatchPlanMapper;
	@Autowired
	ChargeInfoMapper chargeInfoMapper;
	
	@Override
	public List<UserInfo> findOrgUserList(Pager pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void importConsigns(List<ConsignDto> entityList, UserInfo userInfo) throws Exception {
		
		//将导入的运单根据运单号分成主表，同一个运单号里不同的车型成为明细
		List<ConsignDto> consigns = new ArrayList<ConsignDto>();
		List<ConsignDto> consignDetails = new ArrayList<ConsignDto>();
		Map<String, List<ConsignDto>> resultMap = new HashMap<String, List<ConsignDto>>();
		//本次运单号情况
		groupConsignDto(entityList,resultMap);
		//解析resultMap
	    Set<Entry<String, List<ConsignDto>>> set = resultMap.entrySet();
        for (Iterator<Entry<String,  List<ConsignDto>>> it = set.iterator(); it.hasNext();) {
            Entry<String,  List<ConsignDto>> entry = (Entry<String, List<ConsignDto>>) it.next();
            List<ConsignDto> consignDtosByNo= entry.getValue();
            Integer cAmount = 0;
            //生成运单主表id
            final String consignGuid = IdentifieUtil.getGuId();
            for(ConsignDto consignDtoDetail:consignDtosByNo){
            	consignDtoDetail.setConsignId(consignGuid);
            	consignDtoDetail.setConsignFsate(ConsignFstate.UNRETURN);
            	consignDtoDetail.setCreateDate(new Date());
            	consignDtoDetail.setCreateUserId(userInfo.getUserId());
            	consignDtoDetail.setModifyUserId(userInfo.getUserId());
            	consignDtoDetail.setModifyDate(new Date());
            	consignDtoDetail.setOrgId(userInfo.getOrgId());
            	cAmount = cAmount + consignDtoDetail.getAmount();
            	consignDetails.add(consignDtoDetail);
            }
            consignDtosByNo.get(0).setCamount(cAmount);
            consigns.add(consignDtosByNo.get(0));
        }
		//分页批量插入运单主表
		LocalCollectionUtils.paginationProcess(consigns, 1000, new Processer<List<ConsignDto>>(){
			@Override
			public Object process(List<ConsignDto> list) throws Exception {
				return consignMapper.importConsigns(list);
			}
		});
		//分页批量插入运单明细表
		LocalCollectionUtils.paginationProcess(consignDetails, 1000, new Processer<List<ConsignDto>>(){
			@Override
			public Object process(List<ConsignDto> list) throws Exception {
				return consignDetailMapper.importConsignDetails(list);
			}
		});
	}
	
	//根据consignDto里的某个字段分组
	 public void groupConsignDto(List<ConsignDto> list, Map<String, List<ConsignDto>> map) {  
	        if (null == list || null == map) {  
	            return;  
	        }  	  
	        // 按运单号开始分组  
	        String key;  
	        List<ConsignDto> listTmp;  
	        for (ConsignDto val : list) {  
	            key = val.getConsignNo();  
	            listTmp = map.get(key); 
	            if (null == listTmp) {  
	                listTmp = new ArrayList<ConsignDto>();  
	                map.put(key, listTmp);  
	            }  
	            listTmp.add(val);  
	        }  
	    }

	@Override
	public List<Map<String, Object>> findConsignList(Pager<Map<String, Object>> pager) {
		// TODO Auto-generated method stub
		return consignMapper.findConsignList(pager);
	}

	@Override
	public List<Map<String, Object>> searchDispatchInfo(Pager<Map<String, Object>> pager) {
		// TODO Auto-generated method stub
		return despatchPlanMapper.searchDispatchInfo(pager);
	}

	@Override
	public void isWithCarrier(String[] consignNos) throws ValidationException {
		// TODO Auto-generated method stub
		String[] withCarrierCns = desplanConnoMapper.isWithCarrier(consignNos);
		if(withCarrierCns != null && withCarrierCns.length > 0){
			throw new ValidationException("以下运单已安排承运商带，确定要更改承运商？"+StringUtils.join(withCarrierCns, ","));
		}
	}

	@Override
	public void savePlan(DespatchPlan despatchPlan, String[] consignDetailIds, String[] consignNos) throws ValidationException {
		// TODO Auto-generated method stub
		/**一、发运计划和关联信息**/
		//新增发运计划信息
		despatchPlan.setDespatchPlanId(IdentifieUtil.getGuId());
		this.insertInfo(despatchPlan);
//		获取本次操作的运单明细的旧的发运计划ids
		String[] oldPlanIds = consignDetailMapper.searchOldPlanIdsByCDetails(consignDetailIds);
		//批量添加发运计划和运单明细的关系
		consignDetailMapper.batchUpdatePlan(consignDetailIds,despatchPlan.getDespatchPlanId());
		/**二、更新本次发运计划的承运商所带运单信息**/
		if(consignNos != null && consignNos.length >0){
			if(StringUtils.isNotBlank(consignNos[0])){
				//1 批量删除运单号原来关联的发运计划
				desplanConnoMapper.batchDeleteByCnos(consignNos);
				//2 批量增加运单号新的关系
				desplanConnoMapper.batchInsertByCnos(consignNos,despatchPlan.getDespatchPlanId());
			}
		}
		/**三、结费调整**/
//		删除本次编板的运单明细的结费信息
		chargeInfoMapper.batchDeleteByCDetails(consignDetailIds);
//		批量增加本次运单明细结费信息(收入结费)
		chargeInfoMapper.batchProfitInsertByCDetails(consignDetailIds,despatchPlan);
//		批量增加本次运单明细结费信息(承运商结费)
		chargeInfoMapper.batchCostInsertByCDetails(consignDetailIds,despatchPlan);
//		增加司机结费（如果是轿运车承运商是自有的）
		RecordInfo recordInfo = this.find(RecordInfo.class, despatchPlan.getRecordId());
		if(recordInfo == null){
			throw new ValidationException("轿运车档案不存在");
		}
		if( CustomConst.CarrierType.OWN.equals(recordInfo.getCarrierType())){
			if(StringUtils.isBlank(despatchPlan.getLocationFrom()) || 
					StringUtils.isBlank(despatchPlan.getLocationTo())){
				throw new ValidationException("轿运车档案是自有的，为方便司机结费必须选择起运地和目的地");
			}
			chargeInfoMapper.batchDriveInsertByDesplan(despatchPlan);
		}
//		更新结费表里有变化司机结费的车辆数量
		chargeInfoMapper.batchUpdateTamount(oldPlanIds);
//		删除结费表里有可能司机结费数量为0的结费以及其关联的新增的空载结费
		String[] chargeIds = chargeInfoMapper.selectChargesTamountIs0(oldPlanIds);
		if(chargeIds != null && chargeIds.length > 0)
			chargeInfoMapper.batchDeleteTamountIs0(chargeIds);
		/**四、更新发运计划整体信息**/
//		删除没有运单明细关联的发运计划
		despatchPlanMapper.batchDeleteDesPlanIsNull(oldPlanIds);
	}

	@Override
	public void deleteConsignDetail(String[] consignDetailIds) {
		// TODO Auto-generated method stub
//		获取本次操作的运单明细的旧的发运计划ids
		String[] oldPlanIds = consignDetailMapper.searchOldPlanIdsByCDetails(consignDetailIds);
//		删除运单明细
		consignDetailMapper.batchDeleteByIds(consignDetailIds);
//		删除运单明细的结费信息
		chargeInfoMapper.batchDeleteByCDetails(consignDetailIds);
//		如果运单明细关联的运单都删掉了，就删除运单
		consignMapper.clearNoUseConsign();
//		更新结费表里有变化司机结费的车辆数量
		chargeInfoMapper.batchUpdateTamount(oldPlanIds);
//		删除结费表里有可能司机结费数量为0的结费以及其关联的新增的空载结费
		String[] chargeIds = chargeInfoMapper.selectChargesTamountIs0(oldPlanIds);
		if(chargeIds != null && chargeIds.length > 0)
			chargeInfoMapper.batchDeleteTamountIs0(chargeIds);
//		删除没有运单明细关联的发运计划
		despatchPlanMapper.batchDeleteDesPlanIsNull(oldPlanIds);
	}

	@Override
	public void updateConsign(List<Consign> consigns) {
		// TODO Auto-generated method stub
		consignMapper.updateConsign(consigns);
	}

	@Override
	public void insertConsignDto(ConsignDto consigndto) throws ValidationException {
		// TODO Auto-generated method stub
//		0、查询运单号是否已存在，不容许运单号重复
		Consign consign0 = new Consign();
		consign0.setConsignNo(consigndto.getConsignNo());
		List<Consign> consigns = this.searchList(consign0);
		if(consigns != null && consigns.size() > 0){
			throw new ValidationException("运单号已存在，请检查");
		}
//		00、查询底盘号是否已存在，不容许底盘号重复
		ConsignDetail consigndetail0 = new ConsignDetail();
		consigndetail0.setChassisNo(consigndto.getChassisNo());
		List<ConsignDetail> consigndetails = this.searchList(consigndetail0);
		if(consigndetails != null && consigndetails.size() > 0){
			throw new ValidationException("底盘号已存在，请检查");
		}
		
//		1、新增运单主记录
		Consign consign = new Consign();
		consign.setConsignId(IdentifieUtil.getGuId());
		consign.setCamount(consigndto.getCamount());
		consign.setConsignFsate(consigndto.getConsignFsate());
		consign.setConsignNo(consigndto.getConsignNo());
		consign.setConsignOrgName(consigndto.getConsignOrgName());
		consign.setCreateDate(consigndto.getCreateDate());
		consign.setCreateUserId(consigndto.getCreateUserId());
		consign.setLocationFrom(consigndto.getLocationFrom());
		consign.setLocationTo(consigndto.getLocationTo());
		consign.setOrgId(consigndto.getOrgId());
		consign.setReceiveOrgName(consigndto.getReceiveOrgName());
		consign.setModifyDate(consigndto.getModifyDate());
		consign.setModifyUserId(consigndto.getModifyUserId());
		this.insertInfo(consign);
//		2、新增运单明细记录
		ConsignDetail consignDetail = new ConsignDetail();
		consignDetail.setConsignDetailId(IdentifieUtil.getGuId());
		consignDetail.setConsignId(consign.getConsignId());
		consignDetail.setAmount(1);
		consignDetail.setCarBrand(consigndto.getCarBrand());
		consignDetail.setCarModel(consigndto.getCarModel());
		consignDetail.setChassisNo(consigndto.getChassisNo());
		consignDetail.setDespatchFstate(CustomConst.ConsignDetailFstate.UNMAKE);
		consignDetail.setModifyDate(new Date());
		consignDetail.setModifyUserId(consigndto.getModifyUserId());
		this.insertInfo(consignDetail);
	}

	@Override
	public String[] filterExistConsignNos(Object[] array) {
		// TODO Auto-generated method stub
		return consignMapper.filterExistConsignNos(array);
	}

	@Override
	public String[] filterExistChassisNos(Object[] array) {
		// TODO Auto-generated method stub
		return consignMapper.filterExistChassisNos(array);
	}

}
