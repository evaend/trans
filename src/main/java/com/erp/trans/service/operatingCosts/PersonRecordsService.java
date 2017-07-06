package com.erp.trans.service.operatingCosts;

import java.util.List;
import java.util.Map;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.common.service.IBaseService;

public interface PersonRecordsService extends IBaseService{

	List<Map<String, Object>> searchPersonRecords(Pager<Map<String, Object>> pager);

}
