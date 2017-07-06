package com.erp.trans.dao;

import java.util.List;
import java.util.Map;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.entity.VehicleDepreciation;

public interface VehicleDepreciationMapper {
    int insert(VehicleDepreciation record);

    int insertSelective(VehicleDepreciation record);

	List<Map<String, Object>> searchVehicleDep(Pager<Map<String, Object>> pager);
}