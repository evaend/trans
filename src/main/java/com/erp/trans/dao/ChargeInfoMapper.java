package com.erp.trans.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.erp.trans.common.entity.Pager;
import com.erp.trans.entity.ChargeInfo;
import com.erp.trans.entity.DespatchPlan;

public interface ChargeInfoMapper {
    int insert(ChargeInfo record);

    int insertSelective(ChargeInfo record);

	List<Map<String, Object>> searchChargeList(Pager<Map<String, Object>> pager);

	void batchDeleteByCDetails(@Param("consignDetailIds")String[] consignDetailIds);

	void batchCostInsertByCDetails(@Param("consignDetailIds")String[] consignDetailIds, @Param("despatchPlan")DespatchPlan despatchPlan);

	void batchProfitInsertByCDetails(@Param("consignDetailIds")String[] consignDetailIds,@Param("despatchPlan")DespatchPlan despatchPlan);

	void updateChargeInfo(@Param("chargeInfos")List<ChargeInfo> chargeInfos);

	void batchDriveInsertByDesplan(@Param("despatchPlan")DespatchPlan despatchPlan);

	void batchUpdateTamount(@Param("oldPlanIds")String[] oldPlanIds);

	void batchDeleteTamountIs0(@Param("chargeIds")String[] chargeIds);

	String[] selectChargesTamountIs0(@Param("oldPlanIds")String[] oldPlanIds);
}