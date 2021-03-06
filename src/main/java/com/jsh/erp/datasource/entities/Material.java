package com.jsh.erp.datasource.entities;

public class Material {
    private Long id;

    private String name;

    private String factoryNumber;

    private String companySku;

    private String platformSku;

    private String asin;

    private String fnsku;

    private String customsCode;

    private String factoryFinishedGoodsInventory;

    private String kilogram;

    private String along;

    private String width;

    private String height;

    private String innerBoxArea;

    private String nhQuantity;

    private String wxQuantity;

    private String boxLong;

    private String boxWidth;

    private String boxHeight;

    private String boxHeavy;

    private String deleteFlag;

    private String image;

    private String remark;

    private String productCost;

    private String tenantId;

    private String brand;

    private String categoryId;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFactoryNumber() {
        return factoryNumber;
    }

    public void setFactoryNumber(String factoryNumber) {
        this.factoryNumber = factoryNumber == null ? null : factoryNumber.trim();
    }

    public String getCompanySku() {
        return companySku;
    }

    public void setCompanySku(String companySku) {
        this.companySku = companySku == null ? null : companySku.trim();
    }

    public String getPlatformSku() {
        return platformSku;
    }

    public void setPlatformSku(String platformSku) {
        this.platformSku = platformSku == null ? null : platformSku.trim();
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin == null ? null : asin.trim();
    }

    public String getFnsku() {
        return fnsku;
    }

    public void setFnsku(String fnsku) {
        this.fnsku = fnsku == null ? null : fnsku.trim();
    }

    public String getCustomsCode() {
        return customsCode;
    }

    public void setCustomsCode(String customsCode) {
        this.customsCode = customsCode == null ? null : customsCode.trim();
    }

    public String getFactoryFinishedGoodsInventory() {
        return factoryFinishedGoodsInventory;
    }

    public void setFactoryFinishedGoodsInventory(String factoryFinishedGoodsInventory) {
        this.factoryFinishedGoodsInventory = factoryFinishedGoodsInventory == null ? null : factoryFinishedGoodsInventory.trim();
    }

    public String getKilogram() {
        return kilogram;
    }

    public void setKilogram(String kilogram) {
        this.kilogram = kilogram == null ? null : kilogram.trim();
    }

    public String getAlong() {
        return along;
    }

    public void setAlong(String along) {
        this.along = along == null ? null : along.trim();
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width == null ? null : width.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getInnerBoxArea() {
        return innerBoxArea;
    }

    public void setInnerBoxArea(String innerBoxArea) {
        this.innerBoxArea = innerBoxArea == null ? null : innerBoxArea.trim();
    }

    public String getNhQuantity() {
        return nhQuantity;
    }

    public void setNhQuantity(String nhQuantity) {
        this.nhQuantity = nhQuantity == null ? null : nhQuantity.trim();
    }

    public String getWxQuantity() {
        return wxQuantity;
    }

    public void setWxQuantity(String wxQuantity) {
        this.wxQuantity = wxQuantity == null ? null : wxQuantity.trim();
    }

    public String getBoxLong() {
        return boxLong;
    }

    public void setBoxLong(String boxLong) {
        this.boxLong = boxLong == null ? null : boxLong.trim();
    }

    public String getBoxWidth() {
        return boxWidth;
    }

    public void setBoxWidth(String boxWidth) {
        this.boxWidth = boxWidth == null ? null : boxWidth.trim();
    }

    public String getBoxHeight() {
        return boxHeight;
    }

    public void setBoxHeight(String boxHeight) {
        this.boxHeight = boxHeight == null ? null : boxHeight.trim();
    }

    public String getBoxHeavy() {
        return boxHeavy;
    }

    public void setBoxHeavy(String boxHeavy) {
        this.boxHeavy = boxHeavy == null ? null : boxHeavy.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getProductCost() {
        return productCost;
    }

    public void setProductCost(String productCost) {
        this.productCost = productCost == null ? null : productCost.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }
}