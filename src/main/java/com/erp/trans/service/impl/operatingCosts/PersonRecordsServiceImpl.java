package com.erp.trans.service.impl.operatingCosts;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.common.service.impl.BaseService;
import com.erp.trans.dao.PersonRecordsMapper;
import com.erp.trans.service.operatingCosts.PersonRecordsService;

@Service
public class PersonRecordsServiceImpl extends BaseService implements PersonRecordsService {

	@Autowired
	PersonRecordsMapper personRecordsMapper;
	
	@Override
	public List<Map<String, Object>> searchPersonRecords(Pager<Map<String, Object>> pager) {
		// TODO Auto-generated method stub
		return personRecordsMapper.searchPersonRecords(pager);
	}

}
