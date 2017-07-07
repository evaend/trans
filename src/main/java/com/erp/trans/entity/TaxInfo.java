package com.erp.trans.entity;

import java.util.Date;

import com.erp.trans.common.adapter.CustomDateSerializer;
import com.erp.trans.common.annotation.BaseSql;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@BaseSql(tableName="tb_tax_info", resultName="com.erp.trans.dao.TaxInfoMapper.BaseResultMap")
public class TaxInfo {
    private String taxId;
    
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date taxDate;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date modifyDate;

    private String modifyUserid;

    private String orgId;

    private String taxNo;

    private String taxType;

    private String taxAmount;

    private String taxRate;

    private String taxPrice;

    private String taxFreeAmount;

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId == null ? null : taxId.trim();
    }

    public Date getTaxDate() {
        return taxDate;
    }

    public void setTaxDate(Date taxDate) {
        this.taxDate = taxDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyUserid() {
        return modifyUserid;
    }

    public void setModifyUserid(String modifyUserid) {
        this.modifyUserid = modifyUserid == null ? null : modifyUserid.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo == null ? null : taxNo.trim();
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType == null ? null : taxType.trim();
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount == null ? null : taxAmount.trim();
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate == null ? null : taxRate.trim();
    }

    public String getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(String taxPrice) {
        this.taxPrice = taxPrice == null ? null : taxPrice.trim();
    }

    public String getTaxFreeAmount() {
        return taxFreeAmount;
    }

    public void setTaxFreeAmount(String taxFreeAmount) {
        this.taxFreeAmount = taxFreeAmount == null ? null : taxFreeAmount.trim();
    }
}