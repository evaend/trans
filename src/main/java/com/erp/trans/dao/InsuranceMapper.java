package com.erp.trans.dao;

import java.util.List;
import java.util.Map;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.entity.Insurance;

public interface InsuranceMapper {
    int insert(Insurance record);

    int insertSelective(Insurance record);

	List<Map<String, Object>> searchInsurance(Pager<Map<String, Object>> pager);
}