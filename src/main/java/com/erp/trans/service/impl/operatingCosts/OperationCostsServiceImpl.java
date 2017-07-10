package com.erp.trans.service.impl.operatingCosts;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.common.service.impl.BaseService;
import com.erp.trans.dao.InsuranceMapper;
import com.erp.trans.dao.OfficeSpaceFeeMapper;
import com.erp.trans.dao.PersonRecordsMapper;
import com.erp.trans.dao.SalaryMapper;
import com.erp.trans.dao.TaxInfoMapper;
import com.erp.trans.dao.TravelAllowanceMapper;
import com.erp.trans.dao.VehicleDepreciationMapper;
import com.erp.trans.service.operatingCosts.OperationCostsService;

@Service
public class OperationCostsServiceImpl extends BaseService implements OperationCostsService {
	
	private static final String cron = null;

	public final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonRecordsMapper personRecordsMapper;
	@Autowired
	InsuranceMapper insuranceMapper;
	@Autowired
	OfficeSpaceFeeMapper officeSpaceFeeMapper;
	@Autowired
	SalaryMapper salaryMapper;
	@Autowired
	TaxInfoMapper taxInfoMapper;
	@Autowired
	TravelAllowanceMapper travelAllowanceMapper;
	@Autowired
	VehicleDepreciationMapper vehicleDepreciationMapper;

	@Override
	public List<Map<String, Object>> searchPersonSalary(Pager<Map<String, Object>> pager) {
		// TODO Auto-generated method stub		
		return salaryMapper.searchPersonSalary(pager);
	}

	@Override
	public List<Map<String, Object>> searchOfficeSpaceFee(Pager<Map<String, Object>> pager) {
		// TODO Auto-generated method stub
		return officeSpaceFeeMapper.searchOfficeSpaceFee(pager);
	}

	@Override
	public List<Map<String, Object>> searchTravelAllowance(Pager<Map<String, Object>> pager) {
		// TODO Auto-generated method stub
		return travelAllowanceMapper.searchTravelAllowance(pager);
	}

	@Override
	public List<Map<String, Object>> searchTaxInfo(Pager<Map<String, Object>> pager) {
		// TODO Auto-generated method stub
		return taxInfoMapper.searchTaxInfo(pager);
	}

	@Override
	public List<Map<String, Object>> searchVehicleDep(Pager<Map<String, Object>> pager) {
		// TODO Auto-generated method stub
		return vehicleDepreciationMapper.searchVehicleDep(pager);
	}

	@Override
	public List<Map<String, Object>> searchInsurance(Pager<Map<String, Object>> pager) {
		// TODO Auto-generated method stub
		return insuranceMapper.searchInsurance(pager);
	}
	
	/**
	 * 定期生成人员工资表，条件：每个月10号凌晨5点生成
	 */
	@Override
	@Scheduled(cron = "0 38 13 9 * ?")
	public void createSalaryMonth(){
		logger.info("准备生成工资表..");
		//将人员档案加到工资表
		personRecordsMapper.batchCreateSalaryMonth();
		logger.info("工资表生成完毕..");
	}
}
