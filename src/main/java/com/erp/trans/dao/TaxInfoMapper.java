package com.erp.trans.dao;

import java.util.List;
import java.util.Map;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.entity.TaxInfo;

public interface TaxInfoMapper {
    int insert(TaxInfo record);

    int insertSelective(TaxInfo record);

	List<Map<String, Object>> searchTaxInfo(Pager<Map<String, Object>> pager);
}