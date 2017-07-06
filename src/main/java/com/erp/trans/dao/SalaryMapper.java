package com.erp.trans.dao;

import java.util.List;
import java.util.Map;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.entity.Salary;

public interface SalaryMapper {
    int insert(Salary record);

    int insertSelective(Salary record);

	List<Map<String, Object>> searchPersonSalary(Pager<Map<String, Object>> pager);
}