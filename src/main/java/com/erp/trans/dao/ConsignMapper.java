package com.erp.trans.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.entity.Consign;
import com.erp.trans.web.dto.ConsignDto;

public interface ConsignMapper {
    int insert(Consign record);

    int insertSelective(Consign record);

	int importConsigns(List<ConsignDto> list);

	List<Map<String, Object>> findConsignList(Pager<Map<String, Object>> pager);

	void updateConsign(@Param("consigns")List<Consign> consigns);

	void clearNoUseConsign();

	String[] filterExistConsignNos(@Param("consignNos")Object[] consignNos);

	String[] filterExistChassisNos(@Param("chassisNos")Object[] chassisNos);
}