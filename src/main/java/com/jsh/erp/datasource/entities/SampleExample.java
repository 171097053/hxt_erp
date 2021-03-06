package com.jsh.erp.datasource.entities;

import java.util.ArrayList;
import java.util.List;

public class SampleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SampleExample() {
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

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
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

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andImgesIsNull() {
            addCriterion("imges is null");
            return (Criteria) this;
        }

        public Criteria andImgesIsNotNull() {
            addCriterion("imges is not null");
            return (Criteria) this;
        }

        public Criteria andImgesEqualTo(String value) {
            addCriterion("imges =", value, "imges");
            return (Criteria) this;
        }

        public Criteria andImgesNotEqualTo(String value) {
            addCriterion("imges <>", value, "imges");
            return (Criteria) this;
        }

        public Criteria andImgesGreaterThan(String value) {
            addCriterion("imges >", value, "imges");
            return (Criteria) this;
        }

        public Criteria andImgesGreaterThanOrEqualTo(String value) {
            addCriterion("imges >=", value, "imges");
            return (Criteria) this;
        }

        public Criteria andImgesLessThan(String value) {
            addCriterion("imges <", value, "imges");
            return (Criteria) this;
        }

        public Criteria andImgesLessThanOrEqualTo(String value) {
            addCriterion("imges <=", value, "imges");
            return (Criteria) this;
        }

        public Criteria andImgesLike(String value) {
            addCriterion("imges like", value, "imges");
            return (Criteria) this;
        }

        public Criteria andImgesNotLike(String value) {
            addCriterion("imges not like", value, "imges");
            return (Criteria) this;
        }

        public Criteria andImgesIn(List<String> values) {
            addCriterion("imges in", values, "imges");
            return (Criteria) this;
        }

        public Criteria andImgesNotIn(List<String> values) {
            addCriterion("imges not in", values, "imges");
            return (Criteria) this;
        }

        public Criteria andImgesBetween(String value1, String value2) {
            addCriterion("imges between", value1, value2, "imges");
            return (Criteria) this;
        }

        public Criteria andImgesNotBetween(String value1, String value2) {
            addCriterion("imges not between", value1, value2, "imges");
            return (Criteria) this;
        }

        public Criteria andSpecDescIsNull() {
            addCriterion("spec_desc is null");
            return (Criteria) this;
        }

        public Criteria andSpecDescIsNotNull() {
            addCriterion("spec_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSpecDescEqualTo(String value) {
            addCriterion("spec_desc =", value, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescNotEqualTo(String value) {
            addCriterion("spec_desc <>", value, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescGreaterThan(String value) {
            addCriterion("spec_desc >", value, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescGreaterThanOrEqualTo(String value) {
            addCriterion("spec_desc >=", value, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescLessThan(String value) {
            addCriterion("spec_desc <", value, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescLessThanOrEqualTo(String value) {
            addCriterion("spec_desc <=", value, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescLike(String value) {
            addCriterion("spec_desc like", value, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescNotLike(String value) {
            addCriterion("spec_desc not like", value, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescIn(List<String> values) {
            addCriterion("spec_desc in", values, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescNotIn(List<String> values) {
            addCriterion("spec_desc not in", values, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescBetween(String value1, String value2) {
            addCriterion("spec_desc between", value1, value2, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescNotBetween(String value1, String value2) {
            addCriterion("spec_desc not between", value1, value2, "specDesc");
            return (Criteria) this;
        }

        public Criteria andDemaQuanIsNull() {
            addCriterion("dema_quan is null");
            return (Criteria) this;
        }

        public Criteria andDemaQuanIsNotNull() {
            addCriterion("dema_quan is not null");
            return (Criteria) this;
        }

        public Criteria andDemaQuanEqualTo(String value) {
            addCriterion("dema_quan =", value, "demaQuan");
            return (Criteria) this;
        }

        public Criteria andDemaQuanNotEqualTo(String value) {
            addCriterion("dema_quan <>", value, "demaQuan");
            return (Criteria) this;
        }

        public Criteria andDemaQuanGreaterThan(String value) {
            addCriterion("dema_quan >", value, "demaQuan");
            return (Criteria) this;
        }

        public Criteria andDemaQuanGreaterThanOrEqualTo(String value) {
            addCriterion("dema_quan >=", value, "demaQuan");
            return (Criteria) this;
        }

        public Criteria andDemaQuanLessThan(String value) {
            addCriterion("dema_quan <", value, "demaQuan");
            return (Criteria) this;
        }

        public Criteria andDemaQuanLessThanOrEqualTo(String value) {
            addCriterion("dema_quan <=", value, "demaQuan");
            return (Criteria) this;
        }

        public Criteria andDemaQuanLike(String value) {
            addCriterion("dema_quan like", value, "demaQuan");
            return (Criteria) this;
        }

        public Criteria andDemaQuanNotLike(String value) {
            addCriterion("dema_quan not like", value, "demaQuan");
            return (Criteria) this;
        }

        public Criteria andDemaQuanIn(List<String> values) {
            addCriterion("dema_quan in", values, "demaQuan");
            return (Criteria) this;
        }

        public Criteria andDemaQuanNotIn(List<String> values) {
            addCriterion("dema_quan not in", values, "demaQuan");
            return (Criteria) this;
        }

        public Criteria andDemaQuanBetween(String value1, String value2) {
            addCriterion("dema_quan between", value1, value2, "demaQuan");
            return (Criteria) this;
        }

        public Criteria andDemaQuanNotBetween(String value1, String value2) {
            addCriterion("dema_quan not between", value1, value2, "demaQuan");
            return (Criteria) this;
        }

        public Criteria andStatrDataIsNull() {
            addCriterion("statr_data is null");
            return (Criteria) this;
        }

        public Criteria andStatrDataIsNotNull() {
            addCriterion("statr_data is not null");
            return (Criteria) this;
        }

        public Criteria andStatrDataEqualTo(String value) {
            addCriterion("statr_data =", value, "statrData");
            return (Criteria) this;
        }

        public Criteria andStatrDataNotEqualTo(String value) {
            addCriterion("statr_data <>", value, "statrData");
            return (Criteria) this;
        }

        public Criteria andStatrDataGreaterThan(String value) {
            addCriterion("statr_data >", value, "statrData");
            return (Criteria) this;
        }

        public Criteria andStatrDataGreaterThanOrEqualTo(String value) {
            addCriterion("statr_data >=", value, "statrData");
            return (Criteria) this;
        }

        public Criteria andStatrDataLessThan(String value) {
            addCriterion("statr_data <", value, "statrData");
            return (Criteria) this;
        }

        public Criteria andStatrDataLessThanOrEqualTo(String value) {
            addCriterion("statr_data <=", value, "statrData");
            return (Criteria) this;
        }

        public Criteria andStatrDataLike(String value) {
            addCriterion("statr_data like", value, "statrData");
            return (Criteria) this;
        }

        public Criteria andStatrDataNotLike(String value) {
            addCriterion("statr_data not like", value, "statrData");
            return (Criteria) this;
        }

        public Criteria andStatrDataIn(List<String> values) {
            addCriterion("statr_data in", values, "statrData");
            return (Criteria) this;
        }

        public Criteria andStatrDataNotIn(List<String> values) {
            addCriterion("statr_data not in", values, "statrData");
            return (Criteria) this;
        }

        public Criteria andStatrDataBetween(String value1, String value2) {
            addCriterion("statr_data between", value1, value2, "statrData");
            return (Criteria) this;
        }

        public Criteria andStatrDataNotBetween(String value1, String value2) {
            addCriterion("statr_data not between", value1, value2, "statrData");
            return (Criteria) this;
        }

        public Criteria andEndDataIsNull() {
            addCriterion("end_data is null");
            return (Criteria) this;
        }

        public Criteria andEndDataIsNotNull() {
            addCriterion("end_data is not null");
            return (Criteria) this;
        }

        public Criteria andEndDataEqualTo(String value) {
            addCriterion("end_data =", value, "endData");
            return (Criteria) this;
        }

        public Criteria andEndDataNotEqualTo(String value) {
            addCriterion("end_data <>", value, "endData");
            return (Criteria) this;
        }

        public Criteria andEndDataGreaterThan(String value) {
            addCriterion("end_data >", value, "endData");
            return (Criteria) this;
        }

        public Criteria andEndDataGreaterThanOrEqualTo(String value) {
            addCriterion("end_data >=", value, "endData");
            return (Criteria) this;
        }

        public Criteria andEndDataLessThan(String value) {
            addCriterion("end_data <", value, "endData");
            return (Criteria) this;
        }

        public Criteria andEndDataLessThanOrEqualTo(String value) {
            addCriterion("end_data <=", value, "endData");
            return (Criteria) this;
        }

        public Criteria andEndDataLike(String value) {
            addCriterion("end_data like", value, "endData");
            return (Criteria) this;
        }

        public Criteria andEndDataNotLike(String value) {
            addCriterion("end_data not like", value, "endData");
            return (Criteria) this;
        }

        public Criteria andEndDataIn(List<String> values) {
            addCriterion("end_data in", values, "endData");
            return (Criteria) this;
        }

        public Criteria andEndDataNotIn(List<String> values) {
            addCriterion("end_data not in", values, "endData");
            return (Criteria) this;
        }

        public Criteria andEndDataBetween(String value1, String value2) {
            addCriterion("end_data between", value1, value2, "endData");
            return (Criteria) this;
        }

        public Criteria andEndDataNotBetween(String value1, String value2) {
            addCriterion("end_data not between", value1, value2, "endData");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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
        public  Criteria andDeleteFlagNotEqualTo(String value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
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