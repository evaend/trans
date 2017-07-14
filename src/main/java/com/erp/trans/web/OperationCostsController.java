package com.erp.trans.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.erp.trans.entity.Insurance;
import com.erp.trans.entity.OfficeSpaceFee;
import com.erp.trans.entity.Salary;
import com.erp.trans.entity.TaxInfo;
import com.erp.trans.entity.TravelAllowance;
import com.erp.trans.entity.VehicleDepreciation;
import com.erp.trans.service.operatingCosts.OperationCostsService;

/**
 * 运营成本Controller
 * 
 * */
@Controller
@RequestMapping("/operationCosts")
public class OperationCostsController {
    @Autowired
    OperationCostsService operationCostsService;
    
    /**
	 * 人员工资-人员工资查询
	 * 参数pName:人员姓名
	 */
	@RequestMapping("searchPersonSalary")
	@ResponseBody
	public Pager<Map<String, Object>> searchPersonSalary(
			@RequestParam(value = "pName", required = false) String pName,
			@RequestParam(value = "salaryYear", required = false) String salaryYear,
			@RequestParam(value = "salaryMonth", required = false) String salaryMonth,
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
		pager.addQueryParam("salaryYear", salaryYear);//查询年
		pager.addQueryParam("salaryMonth", salaryMonth);//查询月

		List<Map<String, Object>> personSalaryList = operationCostsService.searchPersonSalary(pager);
		pager.setRows(personSalaryList);

		return pager;
	}
	
	/**
	 * 更新人员工资
	 * 参数Salary各字段
	 */
	@ResponseBody
	@RequestMapping(value = "updatePersonSalary")
	public void addUpdatePersonSalary(Salary salary,
			HttpServletRequest request) throws ValidationException {
		// 操作人id
		String userId = (String) request.getSession().getAttribute(LoginUser.SESSION_USERID);
		String orgId = (String) request.getSession().getAttribute(LoginUser.SESSION_USER_ORGID);
		if(salary == null || StringUtils.isBlank(salary.getSalaryId())){
			throw new ValidationException("请选择一跳记录编辑");
		}
		salary.setModifyUserid(userId);
		salary.setModifyDate(new Date());
		salary.setOrgId(orgId);
		operationCostsService.updateInfo(salary);
	
	}
	
	/**
	 * 删除人员工资记录
	 * 参数：salaryIds-人员工资ids
	 */
	@ResponseBody
	@RequestMapping(value = "deletePersonSalary")
	public void deletePersonSalary(@RequestParam(value="salaryIds[]")String[] salaryIds,
			HttpServletRequest request) throws ValidationException {
		if(salaryIds == null){
			throw new ValidationException("请选择人员工资删除");
		}
		for(String salaryId:salaryIds){
			operationCostsService.deleteInfoById(Salary.class, salaryId);
		}
	}
	
	/**
	 * 办公场地费用-办公场地费用查询
	 * 参数officeSpaceName:办公场地地点
	 */
	@RequestMapping("searchOfficeSpaceFee")
	@ResponseBody
	public Pager<Map<String, Object>> searchOfficeSpaceFee(
			@RequestParam(value = "officeSpaceName", required = false) String officeSpaceName,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pagesize", required = false) Integer pagesize, HttpServletRequest request) {
		Pager<Map<String, Object>> pager = new Pager<Map<String, Object>>(true);
		pager.setPageSize(pagesize == null ? 15 : pagesize);
		pager.setPageNum(page == null ? 1 : page);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");// 年-月-日格式化
		// 当前登录用户的机构
		String orgId = (String) request.getSession().getAttribute(LoginUser.SESSION_USER_ORGID);


		pager.addQueryParam("orgId", orgId);// 当前登录机构
		pager.addQueryParam("officeSpaceName", officeSpaceName);//查询姓名

		List<Map<String, Object>> officeSpaceFeeList = operationCostsService.searchOfficeSpaceFee(pager);
		pager.setRows(officeSpaceFeeList);

		return pager;
	}
	
	/**
	 * 新增／更新办公场地费用
	 * 参数OfficeSpaceFee各字段
	 */
	@ResponseBody
	@RequestMapping(value = "addUpdateOfficeSpaceFee")
	public void addUpdateOfficeSpaceFee(OfficeSpaceFee officeSpaceFee,
			HttpServletRequest request) throws ValidationException {
		// 操作人id
		String userId = (String) request.getSession().getAttribute(LoginUser.SESSION_USERID);
		// 操作人机构
		String orgId = (String) request.getSession().getAttribute(LoginUser.SESSION_USER_ORGID);
		if(officeSpaceFee == null){
			throw new ValidationException("请传入办公场地的参数");
		}
		if(StringUtils.isBlank(officeSpaceFee.getOfficeSpaceId())){
			officeSpaceFee.setOfficeSpaceId(IdentifieUtil.getGuId());
			officeSpaceFee.setOrgId(orgId);
			officeSpaceFee.setModifyUserid(userId);
			officeSpaceFee.setModifyDate(new Date());
			operationCostsService.insertInfo(officeSpaceFee);
		}else{
			officeSpaceFee.setModifyUserid(userId);
			officeSpaceFee.setModifyDate(new Date());
			officeSpaceFee.setOrgId(orgId);
			operationCostsService.updateInfoCover(officeSpaceFee);
		}
	}
	
	/**
	 * 删除办公场地费用记录
	 * 参数：officeSpaceIds-办公场地费用记录ids
	 */
	@ResponseBody
	@RequestMapping(value = "deleteOfficeSpaceFee")
	public void deleteOfficeSpaceFee(@RequestParam(value="officeSpaceFeeIds[]")String[]  officeSpaceFeeIds,
			HttpServletRequest request) throws ValidationException {
		if(officeSpaceFeeIds == null){
			throw new ValidationException("请选择办公场地费用记录删除");
		}
		for(String officeSpaceFeeId:officeSpaceFeeIds){
			operationCostsService.deleteInfoById(OfficeSpaceFee.class,officeSpaceFeeId);
		}
	}
	/**
	 * 差旅招待-差旅招待查询
	 * 参数travelers:人员名称
	 */
	@RequestMapping("searchTravelAllowance")
	@ResponseBody
	public Pager<Map<String, Object>> searchTravelAllowance(
			@RequestParam(value = "travelers", required = false) String travelers,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pagesize", required = false) Integer pagesize, HttpServletRequest request) {
		Pager<Map<String, Object>> pager = new Pager<Map<String, Object>>(true);
		pager.setPageSize(pagesize == null ? 15 : pagesize);
		pager.setPageNum(page == null ? 1 : page);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");// 年-月-日格式化
		// 当前登录用户的机构
		String orgId = (String) request.getSession().getAttribute(LoginUser.SESSION_USER_ORGID);


		pager.addQueryParam("orgId", orgId);// 当前登录机构
		pager.addQueryParam("travelers", travelers);//查询姓名

		List<Map<String, Object>> travelAllowanceList = operationCostsService.searchTravelAllowance(pager);
		pager.setRows(travelAllowanceList);

		return pager;
	}
	
	/**
	 * 新增／更新差旅招待
	 * 参数TravelAllowance各字段
	 */
	@ResponseBody
	@RequestMapping(value = "addUpdateTravelAllowance")
	public void addUpdateOfficeSpaceFee(TravelAllowance travelAllowance,
			HttpServletRequest request) throws ValidationException {
		// 操作人id
		String userId = (String) request.getSession().getAttribute(LoginUser.SESSION_USERID);
		// 操作人机构
		String orgId = (String) request.getSession().getAttribute(LoginUser.SESSION_USER_ORGID);
		if(travelAllowance == null){
			throw new ValidationException("请传入差旅招待的参数");
		}
		if(StringUtils.isBlank(travelAllowance.getTravelAllowanceId())){
			travelAllowance.setTravelAllowanceId(IdentifieUtil.getGuId());
			travelAllowance.setOrgId(orgId);
			travelAllowance.setModifyUserid(userId);
			travelAllowance.setModifyDate(new Date());
			operationCostsService.insertInfo(travelAllowance);
		}else{
			travelAllowance.setModifyUserid(userId);
			travelAllowance.setModifyDate(new Date());
			travelAllowance.setOrgId(orgId);
			operationCostsService.updateInfoCover(travelAllowance);
		}
	}
	
	/**
	 * 删除差旅招待记录
	 * 参数：travelAllowanceIds-差旅招待ids
	 */
	@ResponseBody
	@RequestMapping(value = "deleteTravelAllowance")
	public void deleteTravelAllowance(@RequestParam(value="travelAllowanceIds[]")String[] travelAllowanceIds,
			HttpServletRequest request) throws ValidationException {
		if(travelAllowanceIds == null){
			throw new ValidationException("请选择差旅招待记录删除");
		}
		for(String travelAllowanceId : travelAllowanceIds){
			operationCostsService.deleteInfoById(TravelAllowance.class, travelAllowanceId);
		}
	}
	
	/**
	 * 税收-税收查询
	 */
	@RequestMapping("searchTaxInfo")
	@ResponseBody
	public Pager<Map<String, Object>> searchTaxInfo(
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pagesize", required = false) Integer pagesize, HttpServletRequest request) {
		Pager<Map<String, Object>> pager = new Pager<Map<String, Object>>(true);
		pager.setPageSize(pagesize == null ? 15 : pagesize);
		pager.setPageNum(page == null ? 1 : page);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");// 年-月-日格式化
		// 当前登录用户的机构
		String orgId = (String) request.getSession().getAttribute(LoginUser.SESSION_USER_ORGID);


		pager.addQueryParam("orgId", orgId);// 当前登录机构
		pager.addQueryParam("startDate", startDate);//开始日期
		pager.addQueryParam("endDate", endDate);//结束日期

		List<Map<String, Object>> taxInfoList = operationCostsService.searchTaxInfo(pager);
		pager.setRows(taxInfoList);

		return pager;
	}
	
	/**
	 * 新增／更新税收记录
	 * 参数TaxInfo各字段
	 */
	@ResponseBody
	@RequestMapping(value = "addUpdateTaxInfo")
	public void addUpdateTaxInfo(TaxInfo taxInfo,
			HttpServletRequest request) throws ValidationException {
		// 操作人id
		String userId = (String) request.getSession().getAttribute(LoginUser.SESSION_USERID);
		// 操作人机构
		String orgId = (String) request.getSession().getAttribute(LoginUser.SESSION_USER_ORGID);
		if(taxInfo == null){
			throw new ValidationException("请传入税收的参数");
		}
		if(StringUtils.isBlank(taxInfo.getTaxId())){
			taxInfo.setTaxId(IdentifieUtil.getGuId());
			taxInfo.setOrgId(orgId);
			taxInfo.setModifyUserid(userId);
			taxInfo.setModifyDate(new Date());
			operationCostsService.insertInfo(taxInfo);
		}else{
			taxInfo.setModifyUserid(userId);
			taxInfo.setModifyDate(new Date());
			taxInfo.setOrgId(orgId);
			operationCostsService.updateInfoCover(taxInfo);
		}
	}
	
	/**
	 * 删除税收记录
	 * 参数：taxIds-税收记录ids
	 */
	@ResponseBody
	@RequestMapping(value = "deleteTaxInfo")
	public void deleteTaxInfos(@RequestParam(value="taxIds[]")String[] taxIds,
			HttpServletRequest request) throws ValidationException {
		if(taxIds == null){
			throw new ValidationException("请选择税收录删除");
		}
		for(String taxId : taxIds){
			operationCostsService.deleteInfoById(TaxInfo.class, taxId);
		}
	}
	
	/**
	 * 车辆折旧-折旧信息查询
	 */
	@RequestMapping("searchVehicleDep")
	@ResponseBody
	public Pager<Map<String, Object>> searchVehicleDep(
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "transportToolNo", required = false) String transportToolNo,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pagesize", required = false) Integer pagesize, HttpServletRequest request) {
		Pager<Map<String, Object>> pager = new Pager<Map<String, Object>>(true);
		pager.setPageSize(pagesize == null ? 15 : pagesize);
		pager.setPageNum(page == null ? 1 : page);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");// 年-月-日格式化
		// 当前登录用户的机构
		String orgId = (String) request.getSession().getAttribute(LoginUser.SESSION_USER_ORGID);


		pager.addQueryParam("orgId", orgId);// 当前登录机构
		pager.addQueryParam("startDate", startDate);//开始日期
		pager.addQueryParam("endDate", endDate);//结束日期
		pager.addQueryParam("transportToolNo", transportToolNo);//交通工具查询

		List<Map<String, Object>> vehicleDpList = operationCostsService.searchVehicleDep(pager);
		pager.setRows(vehicleDpList);

		return pager;
	}
	
	/**
	 * 新增／更新车辆折旧信息
	 * 参数vehicleDepreciation各字段
	 */
	@ResponseBody
	@RequestMapping(value = "addUpdateVehiceDep")
	public void addUpdateVehiceDep(VehicleDepreciation vehicleDepreciation,
			HttpServletRequest request) throws ValidationException {
		// 操作人id
		String userId = (String) request.getSession().getAttribute(LoginUser.SESSION_USERID);
		// 操作人机构
		String orgId = (String) request.getSession().getAttribute(LoginUser.SESSION_USER_ORGID);
		if(vehicleDepreciation == null){
			throw new ValidationException("请传入车辆折旧的参数");
		}
		if(StringUtils.isBlank(vehicleDepreciation.getVehicleDepreciationId())){
			vehicleDepreciation.setVehicleDepreciationId(IdentifieUtil.getGuId());
			vehicleDepreciation.setOrgId(orgId);
			vehicleDepreciation.setModifyUserid(userId);
			vehicleDepreciation.setModifyDate(new Date());
			operationCostsService.insertInfo(vehicleDepreciation);
		}else{
			vehicleDepreciation.setModifyUserid(userId);
			vehicleDepreciation.setModifyDate(new Date());
			vehicleDepreciation.setOrgId(orgId);
			operationCostsService.updateInfoCover(vehicleDepreciation);
		}
	}
	
	/**
	 * 删除车辆折旧信息
	 * 参数：taxIds-税收记录ids
	 */
	@ResponseBody
	@RequestMapping(value = "deleteVehicleDepreciations")
	public void deleteVehicleDepreciations(@RequestParam(value="vehicleDepreciationIds[]")String[] vehicleDepreciationIds,
			HttpServletRequest request) throws ValidationException {
		if(vehicleDepreciationIds == null){
			throw new ValidationException("请选择车辆折旧记录删除");
		}
		for(String vehicleDepreciationId : vehicleDepreciationIds){
			operationCostsService.deleteInfoById(VehicleDepreciation.class, vehicleDepreciationId);
		}
	}
	
	/**
	 * 保险-保险信息查询
	 */
	@RequestMapping("searchInsurance")
	@ResponseBody
	public Pager<Map<String, Object>> searchInsurance(
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "insuranceYear", required = false) String insuranceYear,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pagesize", required = false) Integer pagesize, HttpServletRequest request) {
		Pager<Map<String, Object>> pager = new Pager<Map<String, Object>>(true);
		pager.setPageSize(pagesize == null ? 15 : pagesize);
		pager.setPageNum(page == null ? 1 : page);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");// 年-月-日格式化
		// 当前登录用户的机构
		String orgId = (String) request.getSession().getAttribute(LoginUser.SESSION_USER_ORGID);


		pager.addQueryParam("orgId", orgId);// 当前登录机构
		pager.addQueryParam("startDate", startDate);//开始日期
		pager.addQueryParam("endDate", endDate);//结束日期
		pager.addQueryParam("insuranceYear", insuranceYear);//baoxiannianfen日期

		List<Map<String, Object>> insuranceList = operationCostsService.searchInsurance(pager);
		pager.setRows(insuranceList);

		return pager;
	}
	
	/**
	 * 新增／更新保险信息
	 * 参数各字段
	 */
	@ResponseBody
	@RequestMapping(value = "addUpdateInsurance")
	public void addUpdateInsurance(Insurance insurance,
			HttpServletRequest request) throws ValidationException {
		// 操作人id
		String userId = (String) request.getSession().getAttribute(LoginUser.SESSION_USERID);
		// 操作人机构
		String orgId = (String) request.getSession().getAttribute(LoginUser.SESSION_USER_ORGID);
		if(insurance == null){
			throw new ValidationException("请传入保险的参数");
		}
		if(StringUtils.isBlank(insurance.getInsuranceId())){
			insurance.setInsuranceId(IdentifieUtil.getGuId());
			insurance.setOrgId(orgId);
			insurance.setModifyUserid(userId);
			insurance.setModifyDate(new Date());
			operationCostsService.insertInfo(insurance);
		}else{
			insurance.setModifyUserid(userId);
			insurance.setModifyDate(new Date());
			insurance.setOrgId(orgId);
			operationCostsService.updateInfoCover(insurance);
		}
	}
	
	/**
	 * 删除保险信息
	 * 参数：insuranceIds-保险记录ids
	 */
	@ResponseBody
	@RequestMapping(value = "deleteInsurances")
	public void deleteInsurances(@RequestParam(value="insuranceIds[]")String[] insuranceIds,
			HttpServletRequest request) throws ValidationException {
		if(insuranceIds == null){
			throw new ValidationException("请选择保险记录删除");
		}
		for(String insuranceId : insuranceIds){
			operationCostsService.deleteInfoById(Insurance.class, insuranceId);
		}
	}


	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateTransfer("yyyy-MM-dd", true));
	}
	
}
