package com.erp.trans.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.trans.common.adapter.CustomDateTransfer;
import com.erp.trans.common.constant.CustomConst.LoginUser;
import com.erp.trans.common.entity.Pager;
import com.erp.trans.common.exception.ValidationException;
import com.erp.trans.common.util.IdentifieUtil;
import com.erp.trans.common.util.LocalAssertUtils;
import com.erp.trans.entity.Contract;
import com.erp.trans.entity.PersonRecords;
import com.erp.trans.entity.RecordInfo;
import com.erp.trans.service.operatingCosts.PersonRecordsService;

/**
 * 人事档案Controller
 * 
 * */
@Controller
@RequestMapping("/personRecords")
public class PersonRecordsController {
    @Autowired
    PersonRecordsService personRecordsService;
    
    /**
	 * 人事档案-人事档案查询
	 * 参数pName:人员姓名
	 */
	@RequestMapping("searchPersonRecords")
	@ResponseBody
	public Pager<Map<String, Object>> searchPersonRecords(
			@RequestParam(value = "pName", required = false) String pName,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pagesize", required = false) Integer pagesize, HttpServletRequest request) {
		Pager<Map<String, Object>> pager = new Pager<Map<String, Object>>(true);
		pager.setPageSize(pagesize == null ? 15 : pagesize);
		pager.setPageNum(page == null ? 1 : page);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");// 年-月-日格式化
		// 当前登录用户的机构
		String orgId = (String) request.getSession().getAttribute(LoginUser.SESSION_USER_ORGID);


		pager.addQueryParam("orgId", orgId);// 当前登录机构
		pager.addQueryParam("pName", pName);//查询姓名

		List<Map<String, Object>> personRecordsList = personRecordsService.searchPersonRecords(pager);
		pager.setRows(personRecordsList);

		return pager;
	}
	
	/**
	 * 新增／更新人事档案信息
	 * 参数PersonRecords各字段
	 */
	@ResponseBody
	@RequestMapping(value = "addUpdatePersonRecord")
	public void addUpdateContractInfo(PersonRecords personRecords,
			HttpServletRequest request) throws ValidationException {
		// 操作人id
		String userId = (String) request.getSession().getAttribute(LoginUser.SESSION_USERID);
		// 操作人机构
		String orgId = (String) request.getSession().getAttribute(LoginUser.SESSION_USER_ORGID);
		if(personRecords == null){
			throw new ValidationException("请传入人事档案的参数");
		}
		if(StringUtils.isBlank(personRecords.getPersonRecordsId())){
			personRecords.setPersonRecordsId(IdentifieUtil.getGuId());
			personRecords.setOrgId(orgId);
			personRecords.setModifyUserid(userId);
			personRecords.setModifyDate(new Date());
			personRecordsService.insertInfo(personRecords);
		}else{
			personRecords.setModifyUserid(userId);
			personRecords.setModifyDate(new Date());
			personRecordsService.updateInfoCover(personRecords);
		}
	}
	
	/**
	 * 删除人事档案
	 * 参数：personRecordsIds-人事档案ids
	 */
	@ResponseBody
	@RequestMapping(value = "deletePersonRecords")
	public void deleteContract(String[] personRecordsIds,
			HttpServletRequest request) throws ValidationException {
		if(personRecordsIds == null){
			throw new ValidationException("请选择人事档案删除");
		}
		for(String personRecordsId:personRecordsIds){
			personRecordsService.deleteInfoById(PersonRecords.class,personRecordsId);
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateTransfer("yyyy-MM-dd", true));
	}
	
}
