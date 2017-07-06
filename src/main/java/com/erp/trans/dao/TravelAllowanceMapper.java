package com.erp.trans.dao;

import java.util.List;
import java.util.Map;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.entity.TravelAllowance;

public interface TravelAllowanceMapper {
    int insert(TravelAllowance record);

    int insertSelective(TravelAllowance record);

	List<Map<String, Object>> searchTravelAllowance(Pager<Map<String, Object>> pager);
}