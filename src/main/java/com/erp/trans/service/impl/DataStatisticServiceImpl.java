package com.erp.trans.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.trans.common.constant.CustomConst;
import com.erp.trans.common.entity.EChart;
import com.erp.trans.common.entity.EChartSeries;
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

		@Override
		public EChart<Map<String, Object>> searchBusinessDataForSta(Pager<Map<String, Object>> pager) {
			// TODO Auto-generated method stub
			String chartType = pager.getConditiions().get("chartType").toString();
			List<String> driveCharge = Arrays.asList("C3","E1","E2","E3");
			List<Map<String, Object>> businessDataList = null;
			if(driveCharge.contains(chartType)){
				businessDataList = consignDetailMapper.searchDriveBusinessDataForSta(pager);
			}else{			
				businessDataList = consignDetailMapper.searchBusinessDataForSta(pager);			
			}
			EChart<Map<String, Object>> eChart = new EChart<Map<String, Object>>();
			Set<String> categories = new HashSet<String>();
			Set<String> data = new HashSet<String>();
			for(Map<String, Object> map:businessDataList){
				categories.add(map.get("categories").toString());
				data.add(map.get("data").toString());
			}
			eChart.setCategories(categories);
			EChartSeries eChartSeries = new EChartSeries();
			eChartSeries.setName(CustomConst.DataStatisticsMap.get(chartType));
			eChartSeries.setData(data);
			eChart.setSeries(eChartSeries);
			return eChart;
		}
}
