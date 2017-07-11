package com.erp.trans.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.common.service.impl.BaseService;
import com.erp.trans.dao.ConsignDetailMapper;
import com.erp.trans.service.DataStatisticsService;

@Service
public class DataStatisticServiceImpl extends BaseService implements DataStatisticsService{
		@Autowired
		ConsignDetailMapper consignDetailMapper;

		@Override
		public List<Map<String, Object>> searchBusinessData(Pager<Map<String, Object>> pager) {
			// TODO Auto-generated method stub
			return consignDetailMapper.searchBusinessData(pager);
		}
}
