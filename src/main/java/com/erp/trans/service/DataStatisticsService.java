package com.erp.trans.service;

import java.util.List;
import java.util.Map;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.common.service.IBaseService;

public interface DataStatisticsService extends IBaseService{

	List<Map<String, Object>> searchBusinessData(Pager<Map<String, Object>> pager);

}
