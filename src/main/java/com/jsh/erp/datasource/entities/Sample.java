package com.jsh.erp.datasource.entities;

public class Sample {
    private Long id;

    private String brand;

    private String factoryNumber;

    private String goodsName;

    private String imges;

    private String specDesc;

    private String demaQuan;

    private String statrData;

    private String endData;

    private String sjendData;

    private String state;

    private String remarks;

    private String tenantId;

    private String deleteFlag;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getFactoryNumber() {
        return factoryNumber;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public void setFactoryNumber(String factoryNumber) {
        this.factoryNumber = factoryNumber == null ? null : factoryNumber.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getImges() {
        return imges;
    }

    public void setImges(String imges) {
        this.imges = imges == null ? null : imges.trim();
    }

    public String getSpecDesc() {
        return specDesc;
    }

    public void setSpecDesc(String specDesc) {
        this.specDesc = specDesc == null ? null : specDesc.trim();
    }

    public String getDemaQuan() {
        return demaQuan;
    }

    public void setDemaQuan(String demaQuan) {
        this.demaQuan = demaQuan == null ? null : demaQuan.trim();
    }

    public String getStatrData() {
        return statrData;
    }

    public void setStatrData(String statrData) {
        this.statrData = statrData == null ? null : statrData.trim();
    }

    public String getEndData() {
        return endData;
    }

    public void setEndData(String endData) {

        this.endData = endData == null ? null : endData.trim();
    }

    public String getSjendData() {
        return sjendData;
    }

    public void setSjendData(String sjendData) {
        this.sjendData = sjendData;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }
}