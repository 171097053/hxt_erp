package com.jsh.erp.datasource.entities;

import java.util.ArrayList;
import java.util.List;

public class MaterialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaterialExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberIsNull() {
            addCriterion("factory_number is null");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberIsNotNull() {
            addCriterion("factory_number is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberEqualTo(String value) {
            addCriterion("factory_number =", value, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberNotEqualTo(String value) {
            addCriterion("factory_number <>", value, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberGreaterThan(String value) {
            addCriterion("factory_number >", value, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberGreaterThanOrEqualTo(String value) {
            addCriterion("factory_number >=", value, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberLessThan(String value) {
            addCriterion("factory_number <", value, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberLessThanOrEqualTo(String value) {
            addCriterion("factory_number <=", value, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberLike(String value) {
            addCriterion("factory_number like", value, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberNotLike(String value) {
            addCriterion("factory_number not like", value, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberIn(List<String> values) {
            addCriterion("factory_number in", values, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberNotIn(List<String> values) {
            addCriterion("factory_number not in", values, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberBetween(String value1, String value2) {
            addCriterion("factory_number between", value1, value2, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andFactoryNumberNotBetween(String value1, String value2) {
            addCriterion("factory_number not between", value1, value2, "factoryNumber");
            return (Criteria) this;
        }

        public Criteria andCompanySkuIsNull() {
            addCriterion("company_sku is null");
            return (Criteria) this;
        }

        public Criteria andCompanySkuIsNotNull() {
            addCriterion("company_sku is not null");
            return (Criteria) this;
        }

        public Criteria andCompanySkuEqualTo(String value) {
            addCriterion("company_sku =", value, "companySku");
            return (Criteria) this;
        }

        public Criteria andCompanySkuNotEqualTo(String value) {
            addCriterion("company_sku <>", value, "companySku");
            return (Criteria) this;
        }

        public Criteria andCompanySkuGreaterThan(String value) {
            addCriterion("company_sku >", value, "companySku");
            return (Criteria) this;
        }

        public Criteria andCompanySkuGreaterThanOrEqualTo(String value) {
            addCriterion("company_sku >=", value, "companySku");
            return (Criteria) this;
        }

        public Criteria andCompanySkuLessThan(String value) {
            addCriterion("company_sku <", value, "companySku");
            return (Criteria) this;
        }

        public Criteria andCompanySkuLessThanOrEqualTo(String value) {
            addCriterion("company_sku <=", value, "companySku");
            return (Criteria) this;
        }

        public Criteria andCompanySkuLike(String value) {
            addCriterion("company_sku like", value, "companySku");
            return (Criteria) this;
        }

        public Criteria andCompanySkuNotLike(String value) {
            addCriterion("company_sku not like", value, "companySku");
            return (Criteria) this;
        }

        public Criteria andCompanySkuIn(List<String> values) {
            addCriterion("company_sku in", values, "companySku");
            return (Criteria) this;
        }

        public Criteria andCompanySkuNotIn(List<String> values) {
            addCriterion("company_sku not in", values, "companySku");
            return (Criteria) this;
        }

        public Criteria andCompanySkuBetween(String value1, String value2) {
            addCriterion("company_sku between", value1, value2, "companySku");
            return (Criteria) this;
        }

        public Criteria andCompanySkuNotBetween(String value1, String value2) {
            addCriterion("company_sku not between", value1, value2, "companySku");
            return (Criteria) this;
        }

        public Criteria andPlatformSkuIsNull() {
            addCriterion("platform_sku is null");
            return (Criteria) this;
        }

        public Criteria andPlatformSkuIsNotNull() {
            addCriterion("platform_sku is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformSkuEqualTo(String value) {
            addCriterion("platform_sku =", value, "platformSku");
            return (Criteria) this;
        }

        public Criteria andPlatformSkuNotEqualTo(String value) {
            addCriterion("platform_sku <>", value, "platformSku");
            return (Criteria) this;
        }

        public Criteria andPlatformSkuGreaterThan(String value) {
            addCriterion("platform_sku >", value, "platformSku");
            return (Criteria) this;
        }

        public Criteria andPlatformSkuGreaterThanOrEqualTo(String value) {
            addCriterion("platform_sku >=", value, "platformSku");
            return (Criteria) this;
        }

        public Criteria andPlatformSkuLessThan(String value) {
            addCriterion("platform_sku <", value, "platformSku");
            return (Criteria) this;
        }

        public Criteria andPlatformSkuLessThanOrEqualTo(String value) {
            addCriterion("platform_sku <=", value, "platformSku");
            return (Criteria) this;
        }

        public Criteria andPlatformSkuLike(String value) {
            addCriterion("platform_sku like", value, "platformSku");
            return (Criteria) this;
        }

        public Criteria andPlatformSkuNotLike(String value) {
            addCriterion("platform_sku not like", value, "platformSku");
            return (Criteria) this;
        }

        public Criteria andPlatformSkuIn(List<String> values) {
            addCriterion("platform_sku in", values, "platformSku");
            return (Criteria) this;
        }

        public Criteria andPlatformSkuNotIn(List<String> values) {
            addCriterion("platform_sku not in", values, "platformSku");
            return (Criteria) this;
        }

        public Criteria andPlatformSkuBetween(String value1, String value2) {
            addCriterion("platform_sku between", value1, value2, "platformSku");
            return (Criteria) this;
        }

        public Criteria andPlatformSkuNotBetween(String value1, String value2) {
            addCriterion("platform_sku not between", value1, value2, "platformSku");
            return (Criteria) this;
        }

        public Criteria andAsinIsNull() {
            addCriterion("asin is null");
            return (Criteria) this;
        }

        public Criteria andAsinIsNotNull() {
            addCriterion("asin is not null");
            return (Criteria) this;
        }

        public Criteria andAsinEqualTo(String value) {
            addCriterion("asin =", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinNotEqualTo(String value) {
            addCriterion("asin <>", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinGreaterThan(String value) {
            addCriterion("asin >", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinGreaterThanOrEqualTo(String value) {
            addCriterion("asin >=", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinLessThan(String value) {
            addCriterion("asin <", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinLessThanOrEqualTo(String value) {
            addCriterion("asin <=", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinLike(String value) {
            addCriterion("asin like", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinNotLike(String value) {
            addCriterion("asin not like", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinIn(List<String> values) {
            addCriterion("asin in", values, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinNotIn(List<String> values) {
            addCriterion("asin not in", values, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinBetween(String value1, String value2) {
            addCriterion("asin between", value1, value2, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinNotBetween(String value1, String value2) {
            addCriterion("asin not between", value1, value2, "asin");
            return (Criteria) this;
        }

        public Criteria andFnskuIsNull() {
            addCriterion("fnsku is null");
            return (Criteria) this;
        }

        public Criteria andFnskuIsNotNull() {
            addCriterion("fnsku is not null");
            return (Criteria) this;
        }

        public Criteria andFnskuEqualTo(String value) {
            addCriterion("fnsku =", value, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuNotEqualTo(String value) {
            addCriterion("fnsku <>", value, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuGreaterThan(String value) {
            addCriterion("fnsku >", value, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuGreaterThanOrEqualTo(String value) {
            addCriterion("fnsku >=", value, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuLessThan(String value) {
            addCriterion("fnsku <", value, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuLessThanOrEqualTo(String value) {
            addCriterion("fnsku <=", value, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuLike(String value) {
            addCriterion("fnsku like", value, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuNotLike(String value) {
            addCriterion("fnsku not like", value, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuIn(List<String> values) {
            addCriterion("fnsku in", values, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuNotIn(List<String> values) {
            addCriterion("fnsku not in", values, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuBetween(String value1, String value2) {
            addCriterion("fnsku between", value1, value2, "fnsku");
            return (Criteria) this;
        }

        public Criteria andFnskuNotBetween(String value1, String value2) {
            addCriterion("fnsku not between", value1, value2, "fnsku");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeIsNull() {
            addCriterion("customs_code is null");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeIsNotNull() {
            addCriterion("customs_code is not null");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeEqualTo(String value) {
            addCriterion("customs_code =", value, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeNotEqualTo(String value) {
            addCriterion("customs_code <>", value, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeGreaterThan(String value) {
            addCriterion("customs_code >", value, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("customs_code >=", value, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeLessThan(String value) {
            addCriterion("customs_code <", value, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeLessThanOrEqualTo(String value) {
            addCriterion("customs_code <=", value, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeLike(String value) {
            addCriterion("customs_code like", value, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeNotLike(String value) {
            addCriterion("customs_code not like", value, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeIn(List<String> values) {
            addCriterion("customs_code in", values, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeNotIn(List<String> values) {
            addCriterion("customs_code not in", values, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeBetween(String value1, String value2) {
            addCriterion("customs_code between", value1, value2, "customsCode");
            return (Criteria) this;
        }

        public Criteria andCustomsCodeNotBetween(String value1, String value2) {
            addCriterion("customs_code not between", value1, value2, "customsCode");
            return (Criteria) this;
        }

        public Criteria andFactoryFinishedGoodsInventoryIsNull() {
            addCriterion("factory_finished_goods_inventory is null");
            return (Criteria) this;
        }

        public Criteria andFactoryFinishedGoodsInventoryIsNotNull() {
            addCriterion("factory_finished_goods_inventory is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryFinishedGoodsInventoryEqualTo(String value) {
            addCriterion("factory_finished_goods_inventory =", value, "factoryFinishedGoodsInventory");
            return (Criteria) this;
        }

        public Criteria andFactoryFinishedGoodsInventoryNotEqualTo(String value) {
            addCriterion("factory_finished_goods_inventory <>", value, "factoryFinishedGoodsInventory");
            return (Criteria) this;
        }

        public Criteria andFactoryFinishedGoodsInventoryGreaterThan(String value) {
            addCriterion("factory_finished_goods_inventory >", value, "factoryFinishedGoodsInventory");
            return (Criteria) this;
        }

        public Criteria andFactoryFinishedGoodsInventoryGreaterThanOrEqualTo(String value) {
            addCriterion("factory_finished_goods_inventory >=", value, "factoryFinishedGoodsInventory");
            return (Criteria) this;
        }

        public Criteria andFactoryFinishedGoodsInventoryLessThan(String value) {
            addCriterion("factory_finished_goods_inventory <", value, "factoryFinishedGoodsInventory");
            return (Criteria) this;
        }

        public Criteria andFactoryFinishedGoodsInventoryLessThanOrEqualTo(String value) {
            addCriterion("factory_finished_goods_inventory <=", value, "factoryFinishedGoodsInventory");
            return (Criteria) this;
        }

        public Criteria andFactoryFinishedGoodsInventoryLike(String value) {
            addCriterion("factory_finished_goods_inventory like", value, "factoryFinishedGoodsInventory");
            return (Criteria) this;
        }

        public Criteria andFactoryFinishedGoodsInventoryNotLike(String value) {
            addCriterion("factory_finished_goods_inventory not like", value, "factoryFinishedGoodsInventory");
            return (Criteria) this;
        }

        public Criteria andFactoryFinishedGoodsInventoryIn(List<String> values) {
            addCriterion("factory_finished_goods_inventory in", values, "factoryFinishedGoodsInventory");
            return (Criteria) this;
        }

        public Criteria andFactoryFinishedGoodsInventoryNotIn(List<String> values) {
            addCriterion("factory_finished_goods_inventory not in", values, "factoryFinishedGoodsInventory");
            return (Criteria) this;
        }

        public Criteria andFactoryFinishedGoodsInventoryBetween(String value1, String value2) {
            addCriterion("factory_finished_goods_inventory between", value1, value2, "factoryFinishedGoodsInventory");
            return (Criteria) this;
        }

        public Criteria andFactoryFinishedGoodsInventoryNotBetween(String value1, String value2) {
            addCriterion("factory_finished_goods_inventory not between", value1, value2, "factoryFinishedGoodsInventory");
            return (Criteria) this;
        }

        public Criteria andKilogramIsNull() {
            addCriterion("Kilogram is null");
            return (Criteria) this;
        }

        public Criteria andKilogramIsNotNull() {
            addCriterion("Kilogram is not null");
            return (Criteria) this;
        }

        public Criteria andKilogramEqualTo(String value) {
            addCriterion("Kilogram =", value, "kilogram");
            return (Criteria) this;
        }

        public Criteria andKilogramNotEqualTo(String value) {
            addCriterion("Kilogram <>", value, "kilogram");
            return (Criteria) this;
        }

        public Criteria andKilogramGreaterThan(String value) {
            addCriterion("Kilogram >", value, "kilogram");
            return (Criteria) this;
        }

        public Criteria andKilogramGreaterThanOrEqualTo(String value) {
            addCriterion("Kilogram >=", value, "kilogram");
            return (Criteria) this;
        }

        public Criteria andKilogramLessThan(String value) {
            addCriterion("Kilogram <", value, "kilogram");
            return (Criteria) this;
        }

        public Criteria andKilogramLessThanOrEqualTo(String value) {
            addCriterion("Kilogram <=", value, "kilogram");
            return (Criteria) this;
        }

        public Criteria andKilogramLike(String value) {
            addCriterion("Kilogram like", value, "kilogram");
            return (Criteria) this;
        }

        public Criteria andKilogramNotLike(String value) {
            addCriterion("Kilogram not like", value, "kilogram");
            return (Criteria) this;
        }

        public Criteria andKilogramIn(List<String> values) {
            addCriterion("Kilogram in", values, "kilogram");
            return (Criteria) this;
        }

        public Criteria andKilogramNotIn(List<String> values) {
            addCriterion("Kilogram not in", values, "kilogram");
            return (Criteria) this;
        }

        public Criteria andKilogramBetween(String value1, String value2) {
            addCriterion("Kilogram between", value1, value2, "kilogram");
            return (Criteria) this;
        }

        public Criteria andKilogramNotBetween(String value1, String value2) {
            addCriterion("Kilogram not between", value1, value2, "kilogram");
            return (Criteria) this;
        }

        public Criteria andAlongIsNull() {
            addCriterion("along is null");
            return (Criteria) this;
        }

        public Criteria andAlongIsNotNull() {
            addCriterion("along is not null");
            return (Criteria) this;
        }

        public Criteria andAlongEqualTo(String value) {
            addCriterion("along =", value, "along");
            return (Criteria) this;
        }

        public Criteria andAlongNotEqualTo(String value) {
            addCriterion("along <>", value, "along");
            return (Criteria) this;
        }

        public Criteria andAlongGreaterThan(String value) {
            addCriterion("along >", value, "along");
            return (Criteria) this;
        }

        public Criteria andAlongGreaterThanOrEqualTo(String value) {
            addCriterion("along >=", value, "along");
            return (Criteria) this;
        }

        public Criteria andAlongLessThan(String value) {
            addCriterion("along <", value, "along");
            return (Criteria) this;
        }

        public Criteria andAlongLessThanOrEqualTo(String value) {
            addCriterion("along <=", value, "along");
            return (Criteria) this;
        }

        public Criteria andAlongLike(String value) {
            addCriterion("along like", value, "along");
            return (Criteria) this;
        }

        public Criteria andAlongNotLike(String value) {
            addCriterion("along not like", value, "along");
            return (Criteria) this;
        }

        public Criteria andAlongIn(List<String> values) {
            addCriterion("along in", values, "along");
            return (Criteria) this;
        }

        public Criteria andAlongNotIn(List<String> values) {
            addCriterion("along not in", values, "along");
            return (Criteria) this;
        }

        public Criteria andAlongBetween(String value1, String value2) {
            addCriterion("along between", value1, value2, "along");
            return (Criteria) this;
        }

        public Criteria andAlongNotBetween(String value1, String value2) {
            addCriterion("along not between", value1, value2, "along");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("width is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("width is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(String value) {
            addCriterion("width =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(String value) {
            addCriterion("width <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(String value) {
            addCriterion("width >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(String value) {
            addCriterion("width >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(String value) {
            addCriterion("width <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(String value) {
            addCriterion("width <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLike(String value) {
            addCriterion("width like", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotLike(String value) {
            addCriterion("width not like", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<String> values) {
            addCriterion("width in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<String> values) {
            addCriterion("width not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(String value1, String value2) {
            addCriterion("width between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(String value1, String value2) {
            addCriterion("width not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(String value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(String value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(String value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(String value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(String value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(String value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLike(String value) {
            addCriterion("height like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotLike(String value) {
            addCriterion("height not like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<String> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<String> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(String value1, String value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(String value1, String value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andInnerBoxAreaIsNull() {
            addCriterion("inner_box_area is null");
            return (Criteria) this;
        }

        public Criteria andInnerBoxAreaIsNotNull() {
            addCriterion("inner_box_area is not null");
            return (Criteria) this;
        }

        public Criteria andInnerBoxAreaEqualTo(String value) {
            addCriterion("inner_box_area =", value, "innerBoxArea");
            return (Criteria) this;
        }

        public Criteria andInnerBoxAreaNotEqualTo(String value) {
            addCriterion("inner_box_area <>", value, "innerBoxArea");
            return (Criteria) this;
        }

        public Criteria andInnerBoxAreaGreaterThan(String value) {
            addCriterion("inner_box_area >", value, "innerBoxArea");
            return (Criteria) this;
        }

        public Criteria andInnerBoxAreaGreaterThanOrEqualTo(String value) {
            addCriterion("inner_box_area >=", value, "innerBoxArea");
            return (Criteria) this;
        }

        public Criteria andInnerBoxAreaLessThan(String value) {
            addCriterion("inner_box_area <", value, "innerBoxArea");
            return (Criteria) this;
        }

        public Criteria andInnerBoxAreaLessThanOrEqualTo(String value) {
            addCriterion("inner_box_area <=", value, "innerBoxArea");
            return (Criteria) this;
        }

        public Criteria andInnerBoxAreaLike(String value) {
            addCriterion("inner_box_area like", value, "innerBoxArea");
            return (Criteria) this;
        }

        public Criteria andInnerBoxAreaNotLike(String value) {
            addCriterion("inner_box_area not like", value, "innerBoxArea");
            return (Criteria) this;
        }

        public Criteria andInnerBoxAreaIn(List<String> values) {
            addCriterion("inner_box_area in", values, "innerBoxArea");
            return (Criteria) this;
        }

        public Criteria andInnerBoxAreaNotIn(List<String> values) {
            addCriterion("inner_box_area not in", values, "innerBoxArea");
            return (Criteria) this;
        }

        public Criteria andInnerBoxAreaBetween(String value1, String value2) {
            addCriterion("inner_box_area between", value1, value2, "innerBoxArea");
            return (Criteria) this;
        }

        public Criteria andInnerBoxAreaNotBetween(String value1, String value2) {
            addCriterion("inner_box_area not between", value1, value2, "innerBoxArea");
            return (Criteria) this;
        }

        public Criteria andNhQuantityIsNull() {
            addCriterion("nh_quantity is null");
            return (Criteria) this;
        }

        public Criteria andNhQuantityIsNotNull() {
            addCriterion("nh_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andNhQuantityEqualTo(String value) {
            addCriterion("nh_quantity =", value, "nhQuantity");
            return (Criteria) this;
        }

        public Criteria andNhQuantityNotEqualTo(String value) {
            addCriterion("nh_quantity <>", value, "nhQuantity");
            return (Criteria) this;
        }

        public Criteria andNhQuantityGreaterThan(String value) {
            addCriterion("nh_quantity >", value, "nhQuantity");
            return (Criteria) this;
        }

        public Criteria andNhQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("nh_quantity >=", value, "nhQuantity");
            return (Criteria) this;
        }

        public Criteria andNhQuantityLessThan(String value) {
            addCriterion("nh_quantity <", value, "nhQuantity");
            return (Criteria) this;
        }

        public Criteria andNhQuantityLessThanOrEqualTo(String value) {
            addCriterion("nh_quantity <=", value, "nhQuantity");
            return (Criteria) this;
        }

        public Criteria andNhQuantityLike(String value) {
            addCriterion("nh_quantity like", value, "nhQuantity");
            return (Criteria) this;
        }

        public Criteria andNhQuantityNotLike(String value) {
            addCriterion("nh_quantity not like", value, "nhQuantity");
            return (Criteria) this;
        }

        public Criteria andNhQuantityIn(List<String> values) {
            addCriterion("nh_quantity in", values, "nhQuantity");
            return (Criteria) this;
        }

        public Criteria andNhQuantityNotIn(List<String> values) {
            addCriterion("nh_quantity not in", values, "nhQuantity");
            return (Criteria) this;
        }

        public Criteria andNhQuantityBetween(String value1, String value2) {
            addCriterion("nh_quantity between", value1, value2, "nhQuantity");
            return (Criteria) this;
        }

        public Criteria andNhQuantityNotBetween(String value1, String value2) {
            addCriterion("nh_quantity not between", value1, value2, "nhQuantity");
            return (Criteria) this;
        }

        public Criteria andWxQuantityIsNull() {
            addCriterion("wx_quantity is null");
            return (Criteria) this;
        }

        public Criteria andWxQuantityIsNotNull() {
            addCriterion("wx_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andWxQuantityEqualTo(String value) {
            addCriterion("wx_quantity =", value, "wxQuantity");
            return (Criteria) this;
        }

        public Criteria andWxQuantityNotEqualTo(String value) {
            addCriterion("wx_quantity <>", value, "wxQuantity");
            return (Criteria) this;
        }

        public Criteria andWxQuantityGreaterThan(String value) {
            addCriterion("wx_quantity >", value, "wxQuantity");
            return (Criteria) this;
        }

        public Criteria andWxQuantityGreaterThanOrEqualTo(String value) {
            addCriterion("wx_quantity >=", value, "wxQuantity");
            return (Criteria) this;
        }

        public Criteria andWxQuantityLessThan(String value) {
            addCriterion("wx_quantity <", value, "wxQuantity");
            return (Criteria) this;
        }

        public Criteria andWxQuantityLessThanOrEqualTo(String value) {
            addCriterion("wx_quantity <=", value, "wxQuantity");
            return (Criteria) this;
        }

        public Criteria andWxQuantityLike(String value) {
            addCriterion("wx_quantity like", value, "wxQuantity");
            return (Criteria) this;
        }

        public Criteria andWxQuantityNotLike(String value) {
            addCriterion("wx_quantity not like", value, "wxQuantity");
            return (Criteria) this;
        }

        public Criteria andWxQuantityIn(List<String> values) {
            addCriterion("wx_quantity in", values, "wxQuantity");
            return (Criteria) this;
        }

        public Criteria andWxQuantityNotIn(List<String> values) {
            addCriterion("wx_quantity not in", values, "wxQuantity");
            return (Criteria) this;
        }

        public Criteria andWxQuantityBetween(String value1, String value2) {
            addCriterion("wx_quantity between", value1, value2, "wxQuantity");
            return (Criteria) this;
        }

        public Criteria andWxQuantityNotBetween(String value1, String value2) {
            addCriterion("wx_quantity not between", value1, value2, "wxQuantity");
            return (Criteria) this;
        }

        public Criteria andBoxLongIsNull() {
            addCriterion("box_long is null");
            return (Criteria) this;
        }

        public Criteria andBoxLongIsNotNull() {
            addCriterion("box_long is not null");
            return (Criteria) this;
        }

        public Criteria andBoxLongEqualTo(String value) {
            addCriterion("box_long =", value, "boxLong");
            return (Criteria) this;
        }

        public Criteria andBoxLongNotEqualTo(String value) {
            addCriterion("box_long <>", value, "boxLong");
            return (Criteria) this;
        }

        public Criteria andBoxLongGreaterThan(String value) {
            addCriterion("box_long >", value, "boxLong");
            return (Criteria) this;
        }

        public Criteria andBoxLongGreaterThanOrEqualTo(String value) {
            addCriterion("box_long >=", value, "boxLong");
            return (Criteria) this;
        }

        public Criteria andBoxLongLessThan(String value) {
            addCriterion("box_long <", value, "boxLong");
            return (Criteria) this;
        }

        public Criteria andBoxLongLessThanOrEqualTo(String value) {
            addCriterion("box_long <=", value, "boxLong");
            return (Criteria) this;
        }

        public Criteria andBoxLongLike(String value) {
            addCriterion("box_long like", value, "boxLong");
            return (Criteria) this;
        }

        public Criteria andBoxLongNotLike(String value) {
            addCriterion("box_long not like", value, "boxLong");
            return (Criteria) this;
        }

        public Criteria andBoxLongIn(List<String> values) {
            addCriterion("box_long in", values, "boxLong");
            return (Criteria) this;
        }

        public Criteria andBoxLongNotIn(List<String> values) {
            addCriterion("box_long not in", values, "boxLong");
            return (Criteria) this;
        }

        public Criteria andBoxLongBetween(String value1, String value2) {
            addCriterion("box_long between", value1, value2, "boxLong");
            return (Criteria) this;
        }

        public Criteria andBoxLongNotBetween(String value1, String value2) {
            addCriterion("box_long not between", value1, value2, "boxLong");
            return (Criteria) this;
        }

        public Criteria andBoxWidthIsNull() {
            addCriterion("box_width is null");
            return (Criteria) this;
        }

        public Criteria andBoxWidthIsNotNull() {
            addCriterion("box_width is not null");
            return (Criteria) this;
        }

        public Criteria andBoxWidthEqualTo(String value) {
            addCriterion("box_width =", value, "boxWidth");
            return (Criteria) this;
        }

        public Criteria andBoxWidthNotEqualTo(String value) {
            addCriterion("box_width <>", value, "boxWidth");
            return (Criteria) this;
        }

        public Criteria andBoxWidthGreaterThan(String value) {
            addCriterion("box_width >", value, "boxWidth");
            return (Criteria) this;
        }

        public Criteria andBoxWidthGreaterThanOrEqualTo(String value) {
            addCriterion("box_width >=", value, "boxWidth");
            return (Criteria) this;
        }

        public Criteria andBoxWidthLessThan(String value) {
            addCriterion("box_width <", value, "boxWidth");
            return (Criteria) this;
        }

        public Criteria andBoxWidthLessThanOrEqualTo(String value) {
            addCriterion("box_width <=", value, "boxWidth");
            return (Criteria) this;
        }

        public Criteria andBoxWidthLike(String value) {
            addCriterion("box_width like", value, "boxWidth");
            return (Criteria) this;
        }

        public Criteria andBoxWidthNotLike(String value) {
            addCriterion("box_width not like", value, "boxWidth");
            return (Criteria) this;
        }

        public Criteria andBoxWidthIn(List<String> values) {
            addCriterion("box_width in", values, "boxWidth");
            return (Criteria) this;
        }

        public Criteria andBoxWidthNotIn(List<String> values) {
            addCriterion("box_width not in", values, "boxWidth");
            return (Criteria) this;
        }

        public Criteria andBoxWidthBetween(String value1, String value2) {
            addCriterion("box_width between", value1, value2, "boxWidth");
            return (Criteria) this;
        }

        public Criteria andBoxWidthNotBetween(String value1, String value2) {
            addCriterion("box_width not between", value1, value2, "boxWidth");
            return (Criteria) this;
        }

        public Criteria andBoxHeightIsNull() {
            addCriterion("box_height is null");
            return (Criteria) this;
        }

        public Criteria andBoxHeightIsNotNull() {
            addCriterion("box_height is not null");
            return (Criteria) this;
        }

        public Criteria andBoxHeightEqualTo(String value) {
            addCriterion("box_height =", value, "boxHeight");
            return (Criteria) this;
        }

        public Criteria andBoxHeightNotEqualTo(String value) {
            addCriterion("box_height <>", value, "boxHeight");
            return (Criteria) this;
        }

        public Criteria andBoxHeightGreaterThan(String value) {
            addCriterion("box_height >", value, "boxHeight");
            return (Criteria) this;
        }

        public Criteria andBoxHeightGreaterThanOrEqualTo(String value) {
            addCriterion("box_height >=", value, "boxHeight");
            return (Criteria) this;
        }

        public Criteria andBoxHeightLessThan(String value) {
            addCriterion("box_height <", value, "boxHeight");
            return (Criteria) this;
        }

        public Criteria andBoxHeightLessThanOrEqualTo(String value) {
            addCriterion("box_height <=", value, "boxHeight");
            return (Criteria) this;
        }

        public Criteria andBoxHeightLike(String value) {
            addCriterion("box_height like", value, "boxHeight");
            return (Criteria) this;
        }

        public Criteria andBoxHeightNotLike(String value) {
            addCriterion("box_height not like", value, "boxHeight");
            return (Criteria) this;
        }

        public Criteria andBoxHeightIn(List<String> values) {
            addCriterion("box_height in", values, "boxHeight");
            return (Criteria) this;
        }

        public Criteria andBoxHeightNotIn(List<String> values) {
            addCriterion("box_height not in", values, "boxHeight");
            return (Criteria) this;
        }

        public Criteria andBoxHeightBetween(String value1, String value2) {
            addCriterion("box_height between", value1, value2, "boxHeight");
            return (Criteria) this;
        }

        public Criteria andBoxHeightNotBetween(String value1, String value2) {
            addCriterion("box_height not between", value1, value2, "boxHeight");
            return (Criteria) this;
        }

        public Criteria andBoxHeavyIsNull() {
            addCriterion("box_heavy is null");
            return (Criteria) this;
        }

        public Criteria andBoxHeavyIsNotNull() {
            addCriterion("box_heavy is not null");
            return (Criteria) this;
        }

        public Criteria andBoxHeavyEqualTo(String value) {
            addCriterion("box_heavy =", value, "boxHeavy");
            return (Criteria) this;
        }

        public Criteria andBoxHeavyNotEqualTo(String value) {
            addCriterion("box_heavy <>", value, "boxHeavy");
            return (Criteria) this;
        }

        public Criteria andBoxHeavyGreaterThan(String value) {
            addCriterion("box_heavy >", value, "boxHeavy");
            return (Criteria) this;
        }

        public Criteria andBoxHeavyGreaterThanOrEqualTo(String value) {
            addCriterion("box_heavy >=", value, "boxHeavy");
            return (Criteria) this;
        }

        public Criteria andBoxHeavyLessThan(String value) {
            addCriterion("box_heavy <", value, "boxHeavy");
            return (Criteria) this;
        }

        public Criteria andBoxHeavyLessThanOrEqualTo(String value) {
            addCriterion("box_heavy <=", value, "boxHeavy");
            return (Criteria) this;
        }

        public Criteria andBoxHeavyLike(String value) {
            addCriterion("box_heavy like", value, "boxHeavy");
            return (Criteria) this;
        }

        public Criteria andBoxHeavyNotLike(String value) {
            addCriterion("box_heavy not like", value, "boxHeavy");
            return (Criteria) this;
        }

        public Criteria andBoxHeavyIn(List<String> values) {
            addCriterion("box_heavy in", values, "boxHeavy");
            return (Criteria) this;
        }

        public Criteria andBoxHeavyNotIn(List<String> values) {
            addCriterion("box_heavy not in", values, "boxHeavy");
            return (Criteria) this;
        }

        public Criteria andBoxHeavyBetween(String value1, String value2) {
            addCriterion("box_heavy between", value1, value2, "boxHeavy");
            return (Criteria) this;
        }

        public Criteria andBoxHeavyNotBetween(String value1, String value2) {
            addCriterion("box_heavy not between", value1, value2, "boxHeavy");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(String value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(String value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(String value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(String value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(String value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(String value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLike(String value) {
            addCriterion("delete_flag like", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotLike(String value) {
            addCriterion("delete_flag not like", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<String> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<String> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(String value1, String value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(String value1, String value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andProductCostIsNull() {
            addCriterion("product_cost is null");
            return (Criteria) this;
        }

        public Criteria andProductCostIsNotNull() {
            addCriterion("product_cost is not null");
            return (Criteria) this;
        }

        public Criteria andProductCostEqualTo(String value) {
            addCriterion("product_cost =", value, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostNotEqualTo(String value) {
            addCriterion("product_cost <>", value, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostGreaterThan(String value) {
            addCriterion("product_cost >", value, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostGreaterThanOrEqualTo(String value) {
            addCriterion("product_cost >=", value, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostLessThan(String value) {
            addCriterion("product_cost <", value, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostLessThanOrEqualTo(String value) {
            addCriterion("product_cost <=", value, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostLike(String value) {
            addCriterion("product_cost like", value, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostNotLike(String value) {
            addCriterion("product_cost not like", value, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostIn(List<String> values) {
            addCriterion("product_cost in", values, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostNotIn(List<String> values) {
            addCriterion("product_cost not in", values, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostBetween(String value1, String value2) {
            addCriterion("product_cost between", value1, value2, "productCost");
            return (Criteria) this;
        }

        public Criteria andProductCostNotBetween(String value1, String value2) {
            addCriterion("product_cost not between", value1, value2, "productCost");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("tenant_id like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("tenant_id not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}