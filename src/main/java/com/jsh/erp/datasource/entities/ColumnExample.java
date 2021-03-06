package com.jsh.erp.datasource.entities;

import java.util.ArrayList;
import java.util.List;

public class ColumnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ColumnExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andFieldIsNull() {
            addCriterion("field is null");
            return (Criteria) this;
        }

        public Criteria andFieldIsNotNull() {
            addCriterion("field is not null");
            return (Criteria) this;
        }

        public Criteria andFieldEqualTo(String value) {
            addCriterion("field =", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotEqualTo(String value) {
            addCriterion("field <>", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldGreaterThan(String value) {
            addCriterion("field >", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldGreaterThanOrEqualTo(String value) {
            addCriterion("field >=", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldLessThan(String value) {
            addCriterion("field <", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldLessThanOrEqualTo(String value) {
            addCriterion("field <=", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldLike(String value) {
            addCriterion("field like", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotLike(String value) {
            addCriterion("field not like", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldIn(List<String> values) {
            addCriterion("field in", values, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotIn(List<String> values) {
            addCriterion("field not in", values, "field");
            return (Criteria) this;
        }

        public Criteria andFieldBetween(String value1, String value2) {
            addCriterion("field between", value1, value2, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotBetween(String value1, String value2) {
            addCriterion("field not between", value1, value2, "field");
            return (Criteria) this;
        }

        public Criteria andAlignIsNull() {
            addCriterion("align is null");
            return (Criteria) this;
        }

        public Criteria andAlignIsNotNull() {
            addCriterion("align is not null");
            return (Criteria) this;
        }

        public Criteria andAlignEqualTo(String value) {
            addCriterion("align =", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignNotEqualTo(String value) {
            addCriterion("align <>", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignGreaterThan(String value) {
            addCriterion("align >", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignGreaterThanOrEqualTo(String value) {
            addCriterion("align >=", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignLessThan(String value) {
            addCriterion("align <", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignLessThanOrEqualTo(String value) {
            addCriterion("align <=", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignLike(String value) {
            addCriterion("align like", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignNotLike(String value) {
            addCriterion("align not like", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignIn(List<String> values) {
            addCriterion("align in", values, "align");
            return (Criteria) this;
        }

        public Criteria andAlignNotIn(List<String> values) {
            addCriterion("align not in", values, "align");
            return (Criteria) this;
        }

        public Criteria andAlignBetween(String value1, String value2) {
            addCriterion("align between", value1, value2, "align");
            return (Criteria) this;
        }

        public Criteria andAlignNotBetween(String value1, String value2) {
            addCriterion("align not between", value1, value2, "align");
            return (Criteria) this;
        }

        public Criteria andCheckboxIsNull() {
            addCriterion("checkbox is null");
            return (Criteria) this;
        }

        public Criteria andCheckboxIsNotNull() {
            addCriterion("checkbox is not null");
            return (Criteria) this;
        }

        public Criteria andCheckboxEqualTo(String value) {
            addCriterion("checkbox =", value, "checkbox");
            return (Criteria) this;
        }

        public Criteria andCheckboxNotEqualTo(String value) {
            addCriterion("checkbox <>", value, "checkbox");
            return (Criteria) this;
        }

        public Criteria andCheckboxGreaterThan(String value) {
            addCriterion("checkbox >", value, "checkbox");
            return (Criteria) this;
        }

        public Criteria andCheckboxGreaterThanOrEqualTo(String value) {
            addCriterion("checkbox >=", value, "checkbox");
            return (Criteria) this;
        }

        public Criteria andCheckboxLessThan(String value) {
            addCriterion("checkbox <", value, "checkbox");
            return (Criteria) this;
        }

        public Criteria andCheckboxLessThanOrEqualTo(String value) {
            addCriterion("checkbox <=", value, "checkbox");
            return (Criteria) this;
        }

        public Criteria andCheckboxLike(String value) {
            addCriterion("checkbox like", value, "checkbox");
            return (Criteria) this;
        }

        public Criteria andCheckboxNotLike(String value) {
            addCriterion("checkbox not like", value, "checkbox");
            return (Criteria) this;
        }

        public Criteria andCheckboxIn(List<String> values) {
            addCriterion("checkbox in", values, "checkbox");
            return (Criteria) this;
        }

        public Criteria andCheckboxNotIn(List<String> values) {
            addCriterion("checkbox not in", values, "checkbox");
            return (Criteria) this;
        }

        public Criteria andCheckboxBetween(String value1, String value2) {
            addCriterion("checkbox between", value1, value2, "checkbox");
            return (Criteria) this;
        }

        public Criteria andCheckboxNotBetween(String value1, String value2) {
            addCriterion("checkbox not between", value1, value2, "checkbox");
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

        public Criteria andHiddenIsNull() {
            addCriterion("hidden is null");
            return (Criteria) this;
        }

        public Criteria andHiddenIsNotNull() {
            addCriterion("hidden is not null");
            return (Criteria) this;
        }

        public Criteria andHiddenEqualTo(Integer value) {
            addCriterion("hidden =", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotEqualTo(Integer value) {
            addCriterion("hidden <>", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenGreaterThan(Integer value) {
            addCriterion("hidden >", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenGreaterThanOrEqualTo(Integer value) {
            addCriterion("hidden >=", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenLessThan(Integer value) {
            addCriterion("hidden <", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenLessThanOrEqualTo(Integer value) {
            addCriterion("hidden <=", value, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenIn(List<Integer> values) {
            addCriterion("hidden in", values, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotIn(List<Integer> values) {
            addCriterion("hidden not in", values, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenBetween(Integer value1, Integer value2) {
            addCriterion("hidden between", value1, value2, "hidden");
            return (Criteria) this;
        }

        public Criteria andHiddenNotBetween(Integer value1, Integer value2) {
            addCriterion("hidden not between", value1, value2, "hidden");
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