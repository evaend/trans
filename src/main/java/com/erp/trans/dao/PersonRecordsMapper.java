package com.erp.trans.dao;

import java.util.List;
import java.util.Map;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.entity.PersonRecords;

public interface PersonRecordsMapper {
    int insert(PersonRecords record);

    int insertSelective(PersonRecords record);

	List<Map<String, Object>> searchPersonRecords(Pager<Map<String, Object>> pager);

	void batchCreateSalaryMonth();
}