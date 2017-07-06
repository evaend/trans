package com.erp.trans.entity;

import java.util.Date;

import com.erp.trans.common.annotation.BaseSql;

@BaseSql(tableName="tb_salary", resultName="com.erp.trans.dao.SalaryMapper.BaseResultMap")
public class Salary {
    private String salaryId;

    private String personRecordsId;

    private String salaryYear;

    private String salaryMonth;

    private String basePay;

    private String positionSalary;

    private String evaluationReward;

    private String trafficCommunications;

    private String seniorityPay;

    private String payRetro;

    private String payDedu;

    private Date modifyDate;

    private String modifyUserid;

    private String orgId;

    private String actualPay;

    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String salaryId) {
        this.salaryId = salaryId == null ? null : salaryId.trim();
    }

    public String getPersonRecordsId() {
        return personRecordsId;
    }

    public void setPersonRecordsId(String personRecordsId) {
        this.personRecordsId = personRecordsId == null ? null : personRecordsId.trim();
    }

    public String getSalaryYear() {
        return salaryYear;
    }

    public void setSalaryYear(String salaryYear) {
        this.salaryYear = salaryYear == null ? null : salaryYear.trim();
    }

    public String getSalaryMonth() {
        return salaryMonth;
    }

    public void setSalaryMonth(String salaryMonth) {
        this.salaryMonth = salaryMonth == null ? null : salaryMonth.trim();
    }

    public String getBasePay() {
        return basePay;
    }

    public void setBasePay(String basePay) {
        this.basePay = basePay == null ? null : basePay.trim();
    }

    public String getPositionSalary() {
        return positionSalary;
    }

    public void setPositionSalary(String positionSalary) {
        this.positionSalary = positionSalary == null ? null : positionSalary.trim();
    }

    public String getEvaluationReward() {
        return evaluationReward;
    }

    public void setEvaluationReward(String evaluationReward) {
        this.evaluationReward = evaluationReward == null ? null : evaluationReward.trim();
    }

    public String getTrafficCommunications() {
        return trafficCommunications;
    }

    public void setTrafficCommunications(String trafficCommunications) {
        this.trafficCommunications = trafficCommunications == null ? null : trafficCommunications.trim();
    }

    public String getSeniorityPay() {
        return seniorityPay;
    }

    public void setSeniorityPay(String seniorityPay) {
        this.seniorityPay = seniorityPay == null ? null : seniorityPay.trim();
    }

    public String getPayRetro() {
        return payRetro;
    }

    public void setPayRetro(String payRetro) {
        this.payRetro = payRetro == null ? null : payRetro.trim();
    }

    public String getPayDedu() {
        return payDedu;
    }

    public void setPayDedu(String payDedu) {
        this.payDedu = payDedu == null ? null : payDedu.trim();
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

    public String getActualPay() {
        return actualPay;
    }

    public void setActualPay(String actualPay) {
        this.actualPay = actualPay == null ? null : actualPay.trim();
    }
}