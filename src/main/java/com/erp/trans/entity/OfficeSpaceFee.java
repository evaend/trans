package com.erp.trans.entity;

import java.util.Date;

import com.erp.trans.common.adapter.CustomDateSerializer;
import com.erp.trans.common.annotation.BaseSql;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@BaseSql(tableName="tb_office_space_fee", resultName="com.erp.trans.dao.OfficeSpaceFeeMapper.BaseResultMap")
public class OfficeSpaceFee {
    private String officeSpaceId;

    private String officeSpaceName;

    private Long monthRent;

    private String lease;

    private Date modifyDate;

    private String modifyUserid;

    private String orgId;
    
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date rentDate;

    public String getOfficeSpaceId() {
        return officeSpaceId;
    }

    public void setOfficeSpaceId(String officeSpaceId) {
        this.officeSpaceId = officeSpaceId == null ? null : officeSpaceId.trim();
    }

    public String getOfficeSpaceName() {
        return officeSpaceName;
    }

    public void setOfficeSpaceName(String officeSpaceName) {
        this.officeSpaceName = officeSpaceName == null ? null : officeSpaceName.trim();
    }

    public Long getMonthRent() {
        return monthRent;
    }

    public void setMonthRent(Long monthRent) {
        this.monthRent = monthRent;
    }

    public String getLease() {
        return lease;
    }

    public void setLease(String lease) {
        this.lease = lease == null ? null : lease.trim();
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

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}
    
}