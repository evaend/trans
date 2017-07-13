package com.erp.trans.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.entity.ConsignDetail;
import com.erp.trans.web.dto.ConsignDto;

public interface ConsignDetailMapper {
    int insert(ConsignDetail record);

    int insertSelective(ConsignDetail record);

	int importConsignDetails(List<ConsignDto> list);

	void batchUpdatePlan(@Param("consignDetailIds")String[] consignDetailIds, @Param("despatchPlanId")String despatchPlanId);

	void batchDeleteByIds(@Param("consignDetailIds")String[] consignDetailIds);

	String[] searchOldPlanIdsByCDetails(@Param("consignDetailIds")String[] consignDetailIds);

	List<Map<String, Object>> searchBusinessData(Pager<Map<String, Object>> pager);

	List<Map<String, Object>> searchBusinessDataForSta(Pager<Map<String, Object>> pager);

	List<Map<String, Object>> searchDriveBusinessDataForSta(Pager<Map<String, Object>> pager);
}