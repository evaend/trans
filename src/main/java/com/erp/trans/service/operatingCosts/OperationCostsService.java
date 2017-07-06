package com.erp.trans.service.operatingCosts;

import java.util.List;
import java.util.Map;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.common.service.IBaseService;

public interface OperationCostsService extends IBaseService{

	List<Map<String, Object>> searchPersonSalary(Pager<Map<String, Object>> pager);

	List<Map<String, Object>> searchOfficeSpaceFee(Pager<Map<String, Object>> pager);

	List<Map<String, Object>> searchTravelAllowance(Pager<Map<String, Object>> pager);

	List<Map<String, Object>> searchTaxInfo(Pager<Map<String, Object>> pager);

	List<Map<String, Object>> searchVehicleDep(Pager<Map<String, Object>> pager);

	List<Map<String, Object>> searchInsurance(Pager<Map<String, Object>> pager);

	void createSalaryMonth();

}
