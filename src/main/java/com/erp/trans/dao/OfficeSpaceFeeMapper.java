package com.erp.trans.dao;

import java.util.List;
import java.util.Map;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.entity.OfficeSpaceFee;

public interface OfficeSpaceFeeMapper {
    int insert(OfficeSpaceFee record);

    int insertSelective(OfficeSpaceFee record);

	List<Map<String, Object>> searchOfficeSpaceFee(Pager<Map<String, Object>> pager);
}