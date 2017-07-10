package com.erp.trans.entity;

import java.util.Date;

import com.erp.trans.common.annotation.BaseSql;

@BaseSql(tableName="tb_charge_info", resultName="com.erp.trans.dao.ChargeInfoMapper.BaseResultMap")
public class ChargeInfo {
    private String chargeId;

    private String orgId;

    private String chargeType;

    private String freightRates;

    private String freight;

    private String advances;

    private String prepaidOilCard;

    private String qualityLoss;

    private String subsidy;

    private String reverseCharge;

    private String misCosts;

    private String gpsPayment;

    private String chargeAmount;

    private String mainDrive;

    private String coPilot;

    private String tranportTool;

    private String despatchPlanId;

    private String consignDetailId;

    private String contractId;

    private Date modifyDate;

    private String modifyUserId;
    
    private String modifyUserName;
    
    private String chargeFstate;
    
    private String kiloPrice;
    private String kilometers;
    private String oilCost;
    private String serviceRate;
    private String oilRatio;
    private String oilPrice;
    private String oilSubsidy;
    
    private String sourceChargeId;
    private String locationFrom;
    private String locationTo;
    private String tamount;

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId == null ? null : chargeId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public String getFreightRates() {
        return freightRates;
    }

    public void setFreightRates(String freightRates) {
        this.freightRates = freightRates == null ? null : freightRates.trim();
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight == null ? null : freight.trim();
    }

    public String getAdvances() {
        return advances;
    }

    public void setAdvances(String advances) {
        this.advances = advances == null ? null : advances.trim();
    }

    public String getPrepaidOilCard() {
        return prepaidOilCard;
    }

    public void setPrepaidOilCard(String prepaidOilCard) {
        this.prepaidOilCard = prepaidOilCard == null ? null : prepaidOilCard.trim();
    }

    public String getQualityLoss() {
        return qualityLoss;
    }

    public void setQualityLoss(String qualityLoss) {
        this.qualityLoss = qualityLoss == null ? null : qualityLoss.trim();
    }

    public String getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(String subsidy) {
        this.subsidy = subsidy == null ? null : subsidy.trim();
    }

    public String getReverseCharge() {
        return reverseCharge;
    }

    public void setReverseCharge(String reverseCharge) {
        this.reverseCharge = reverseCharge == null ? null : reverseCharge.trim();
    }

    public String getMisCosts() {
        return misCosts;
    }

    public void setMisCosts(String misCosts) {
        this.misCosts = misCosts == null ? null : misCosts.trim();
    }

    public String getGpsPayment() {
        return gpsPayment;
    }

    public void setGpsPayment(String gpsPayment) {
        this.gpsPayment = gpsPayment == null ? null : gpsPayment.trim();
    }

    public String getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(String chargeAmount) {
        this.chargeAmount = chargeAmount == null ? null : chargeAmount.trim();
    }

    public String getMainDrive() {
        return mainDrive;
    }

    public void setMainDrive(String mainDrive) {
        this.mainDrive = mainDrive == null ? null : mainDrive.trim();
    }

    public String getCoPilot() {
        return coPilot;
    }

    public void setCoPilot(String coPilot) {
        this.coPilot = coPilot == null ? null : coPilot.trim();
    }

    public String getTranportTool() {
        return tranportTool;
    }

    public void setTranportTool(String tranportTool) {
        this.tranportTool = tranportTool == null ? null : tranportTool.trim();
    }

    public String getDespatchPlanId() {
        return despatchPlanId;
    }

    public void setDespatchPlanId(String despatchPlanId) {
        this.despatchPlanId = despatchPlanId == null ? null : despatchPlanId.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId == null ? null : modifyUserId.trim();
    }

	public String getConsignDetailId() {
		return consignDetailId;
	}

	public void setConsignDetailId(String consignDetailId) {
		this.consignDetailId = consignDetailId;
	}

	public String getModifyUserName() {
		return modifyUserName;
	}

	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}

	public String getChargeFstate() {
		return chargeFstate;
	}

	public void setChargeFstate(String chargeFstate) {
		this.chargeFstate = chargeFstate;
	}

	public String getKiloPrice() {
		return kiloPrice;
	}

	public void setKiloPrice(String kiloPrice) {
		this.kiloPrice = kiloPrice;
	}

	public String getKilometers() {
		return kilometers;
	}

	public void setKilometers(String kilometers) {
		this.kilometers = kilometers;
	}

	
	public String getOilCost() {
		return oilCost;
	}

	public void setOilCost(String oilCost) {
		this.oilCost = oilCost;
	}

	public String getServiceRate() {
		return serviceRate;
	}

	public void setServiceRate(String serviceRate) {
		this.serviceRate = serviceRate;
	}

	public String getOilRatio() {
		return oilRatio;
	}

	public void setOilRatio(String oilRatio) {
		this.oilRatio = oilRatio;
	}

	public String getOilPrice() {
		return oilPrice;
	}

	public void setOilPrice(String oilPrice) {
		this.oilPrice = oilPrice;
	}

	public String getOilSubsidy() {
		return oilSubsidy;
	}

	public void setOilSubsidy(String oilSubsidy) {
		this.oilSubsidy = oilSubsidy;
	}

	public String getSourceChargeId() {
		return sourceChargeId;
	}

	public void setSourceChargeId(String sourceChargeId) {
		this.sourceChargeId = sourceChargeId;
	}

	public String getLocationFrom() {
		return locationFrom;
	}

	public void setLocationFrom(String locationFrom) {
		this.locationFrom = locationFrom;
	}

	public String getLocationTo() {
		return locationTo;
	}

	public void setLocationTo(String locationTo) {
		this.locationTo = locationTo;
	}

	public String getTamount() {
		return tamount;
	}

	public void setTamount(String tamount) {
		this.tamount = tamount;
	}
	
}