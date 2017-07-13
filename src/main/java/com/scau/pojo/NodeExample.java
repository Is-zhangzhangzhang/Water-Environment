package com.scau.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NodeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table node
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table node
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table node
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    public NodeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table node
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table node
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        public Criteria andNodeIdIsNull() {
            addCriterion("node_id is null");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNotNull() {
            addCriterion("node_id is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIdEqualTo(Integer value) {
            addCriterion("node_id =", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotEqualTo(Integer value) {
            addCriterion("node_id <>", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThan(Integer value) {
            addCriterion("node_id >", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_id >=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThan(Integer value) {
            addCriterion("node_id <", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("node_id <=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIn(List<Integer> values) {
            addCriterion("node_id in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotIn(List<Integer> values) {
            addCriterion("node_id not in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdBetween(Integer value1, Integer value2) {
            addCriterion("node_id between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("node_id not between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNull() {
            addCriterion("node_name is null");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNotNull() {
            addCriterion("node_name is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNameEqualTo(String value) {
            addCriterion("node_name =", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotEqualTo(String value) {
            addCriterion("node_name <>", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThan(String value) {
            addCriterion("node_name >", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("node_name >=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThan(String value) {
            addCriterion("node_name <", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThanOrEqualTo(String value) {
            addCriterion("node_name <=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLike(String value) {
            addCriterion("node_name like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotLike(String value) {
            addCriterion("node_name not like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameIn(List<String> values) {
            addCriterion("node_name in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotIn(List<String> values) {
            addCriterion("node_name not in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameBetween(String value1, String value2) {
            addCriterion("node_name between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotBetween(String value1, String value2) {
            addCriterion("node_name not between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeStatusIsNull() {
            addCriterion("node_status is null");
            return (Criteria) this;
        }

        public Criteria andNodeStatusIsNotNull() {
            addCriterion("node_status is not null");
            return (Criteria) this;
        }

        public Criteria andNodeStatusEqualTo(String value) {
            addCriterion("node_status =", value, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusNotEqualTo(String value) {
            addCriterion("node_status <>", value, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusGreaterThan(String value) {
            addCriterion("node_status >", value, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("node_status >=", value, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusLessThan(String value) {
            addCriterion("node_status <", value, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusLessThanOrEqualTo(String value) {
            addCriterion("node_status <=", value, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusLike(String value) {
            addCriterion("node_status like", value, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusNotLike(String value) {
            addCriterion("node_status not like", value, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusIn(List<String> values) {
            addCriterion("node_status in", values, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusNotIn(List<String> values) {
            addCriterion("node_status not in", values, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusBetween(String value1, String value2) {
            addCriterion("node_status between", value1, value2, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeStatusNotBetween(String value1, String value2) {
            addCriterion("node_status not between", value1, value2, "nodeStatus");
            return (Criteria) this;
        }

        public Criteria andNodeIpIsNull() {
            addCriterion("node_ip is null");
            return (Criteria) this;
        }

        public Criteria andNodeIpIsNotNull() {
            addCriterion("node_ip is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIpEqualTo(String value) {
            addCriterion("node_ip =", value, "nodeIp");
            return (Criteria) this;
        }

        public Criteria andNodeIpNotEqualTo(String value) {
            addCriterion("node_ip <>", value, "nodeIp");
            return (Criteria) this;
        }

        public Criteria andNodeIpGreaterThan(String value) {
            addCriterion("node_ip >", value, "nodeIp");
            return (Criteria) this;
        }

        public Criteria andNodeIpGreaterThanOrEqualTo(String value) {
            addCriterion("node_ip >=", value, "nodeIp");
            return (Criteria) this;
        }

        public Criteria andNodeIpLessThan(String value) {
            addCriterion("node_ip <", value, "nodeIp");
            return (Criteria) this;
        }

        public Criteria andNodeIpLessThanOrEqualTo(String value) {
            addCriterion("node_ip <=", value, "nodeIp");
            return (Criteria) this;
        }

        public Criteria andNodeIpLike(String value) {
            addCriterion("node_ip like", value, "nodeIp");
            return (Criteria) this;
        }

        public Criteria andNodeIpNotLike(String value) {
            addCriterion("node_ip not like", value, "nodeIp");
            return (Criteria) this;
        }

        public Criteria andNodeIpIn(List<String> values) {
            addCriterion("node_ip in", values, "nodeIp");
            return (Criteria) this;
        }

        public Criteria andNodeIpNotIn(List<String> values) {
            addCriterion("node_ip not in", values, "nodeIp");
            return (Criteria) this;
        }

        public Criteria andNodeIpBetween(String value1, String value2) {
            addCriterion("node_ip between", value1, value2, "nodeIp");
            return (Criteria) this;
        }

        public Criteria andNodeIpNotBetween(String value1, String value2) {
            addCriterion("node_ip not between", value1, value2, "nodeIp");
            return (Criteria) this;
        }

        public Criteria andNodeSpecificationIsNull() {
            addCriterion("node_specification is null");
            return (Criteria) this;
        }

        public Criteria andNodeSpecificationIsNotNull() {
            addCriterion("node_specification is not null");
            return (Criteria) this;
        }

        public Criteria andNodeSpecificationEqualTo(String value) {
            addCriterion("node_specification =", value, "nodeSpecification");
            return (Criteria) this;
        }

        public Criteria andNodeSpecificationNotEqualTo(String value) {
            addCriterion("node_specification <>", value, "nodeSpecification");
            return (Criteria) this;
        }

        public Criteria andNodeSpecificationGreaterThan(String value) {
            addCriterion("node_specification >", value, "nodeSpecification");
            return (Criteria) this;
        }

        public Criteria andNodeSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("node_specification >=", value, "nodeSpecification");
            return (Criteria) this;
        }

        public Criteria andNodeSpecificationLessThan(String value) {
            addCriterion("node_specification <", value, "nodeSpecification");
            return (Criteria) this;
        }

        public Criteria andNodeSpecificationLessThanOrEqualTo(String value) {
            addCriterion("node_specification <=", value, "nodeSpecification");
            return (Criteria) this;
        }

        public Criteria andNodeSpecificationLike(String value) {
            addCriterion("node_specification like", value, "nodeSpecification");
            return (Criteria) this;
        }

        public Criteria andNodeSpecificationNotLike(String value) {
            addCriterion("node_specification not like", value, "nodeSpecification");
            return (Criteria) this;
        }

        public Criteria andNodeSpecificationIn(List<String> values) {
            addCriterion("node_specification in", values, "nodeSpecification");
            return (Criteria) this;
        }

        public Criteria andNodeSpecificationNotIn(List<String> values) {
            addCriterion("node_specification not in", values, "nodeSpecification");
            return (Criteria) this;
        }

        public Criteria andNodeSpecificationBetween(String value1, String value2) {
            addCriterion("node_specification between", value1, value2, "nodeSpecification");
            return (Criteria) this;
        }

        public Criteria andNodeSpecificationNotBetween(String value1, String value2) {
            addCriterion("node_specification not between", value1, value2, "nodeSpecification");
            return (Criteria) this;
        }

        public Criteria andNodeRoleIsNull() {
            addCriterion("node_role is null");
            return (Criteria) this;
        }

        public Criteria andNodeRoleIsNotNull() {
            addCriterion("node_role is not null");
            return (Criteria) this;
        }

        public Criteria andNodeRoleEqualTo(String value) {
            addCriterion("node_role =", value, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleNotEqualTo(String value) {
            addCriterion("node_role <>", value, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleGreaterThan(String value) {
            addCriterion("node_role >", value, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleGreaterThanOrEqualTo(String value) {
            addCriterion("node_role >=", value, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleLessThan(String value) {
            addCriterion("node_role <", value, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleLessThanOrEqualTo(String value) {
            addCriterion("node_role <=", value, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleLike(String value) {
            addCriterion("node_role like", value, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleNotLike(String value) {
            addCriterion("node_role not like", value, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleIn(List<String> values) {
            addCriterion("node_role in", values, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleNotIn(List<String> values) {
            addCriterion("node_role not in", values, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleBetween(String value1, String value2) {
            addCriterion("node_role between", value1, value2, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeRoleNotBetween(String value1, String value2) {
            addCriterion("node_role not between", value1, value2, "nodeRole");
            return (Criteria) this;
        }

        public Criteria andNodeCreaterIsNull() {
            addCriterion("node_creater is null");
            return (Criteria) this;
        }

        public Criteria andNodeCreaterIsNotNull() {
            addCriterion("node_creater is not null");
            return (Criteria) this;
        }

        public Criteria andNodeCreaterEqualTo(String value) {
            addCriterion("node_creater =", value, "nodeCreater");
            return (Criteria) this;
        }

        public Criteria andNodeCreaterNotEqualTo(String value) {
            addCriterion("node_creater <>", value, "nodeCreater");
            return (Criteria) this;
        }

        public Criteria andNodeCreaterGreaterThan(String value) {
            addCriterion("node_creater >", value, "nodeCreater");
            return (Criteria) this;
        }

        public Criteria andNodeCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("node_creater >=", value, "nodeCreater");
            return (Criteria) this;
        }

        public Criteria andNodeCreaterLessThan(String value) {
            addCriterion("node_creater <", value, "nodeCreater");
            return (Criteria) this;
        }

        public Criteria andNodeCreaterLessThanOrEqualTo(String value) {
            addCriterion("node_creater <=", value, "nodeCreater");
            return (Criteria) this;
        }

        public Criteria andNodeCreaterLike(String value) {
            addCriterion("node_creater like", value, "nodeCreater");
            return (Criteria) this;
        }

        public Criteria andNodeCreaterNotLike(String value) {
            addCriterion("node_creater not like", value, "nodeCreater");
            return (Criteria) this;
        }

        public Criteria andNodeCreaterIn(List<String> values) {
            addCriterion("node_creater in", values, "nodeCreater");
            return (Criteria) this;
        }

        public Criteria andNodeCreaterNotIn(List<String> values) {
            addCriterion("node_creater not in", values, "nodeCreater");
            return (Criteria) this;
        }

        public Criteria andNodeCreaterBetween(String value1, String value2) {
            addCriterion("node_creater between", value1, value2, "nodeCreater");
            return (Criteria) this;
        }

        public Criteria andNodeCreaterNotBetween(String value1, String value2) {
            addCriterion("node_creater not between", value1, value2, "nodeCreater");
            return (Criteria) this;
        }

        public Criteria andNodeTimeIsNull() {
            addCriterion("node_time is null");
            return (Criteria) this;
        }

        public Criteria andNodeTimeIsNotNull() {
            addCriterion("node_time is not null");
            return (Criteria) this;
        }

        public Criteria andNodeTimeEqualTo(Date value) {
            addCriterion("node_time =", value, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeNotEqualTo(Date value) {
            addCriterion("node_time <>", value, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeGreaterThan(Date value) {
            addCriterion("node_time >", value, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("node_time >=", value, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeLessThan(Date value) {
            addCriterion("node_time <", value, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeLessThanOrEqualTo(Date value) {
            addCriterion("node_time <=", value, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeIn(List<Date> values) {
            addCriterion("node_time in", values, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeNotIn(List<Date> values) {
            addCriterion("node_time not in", values, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeBetween(Date value1, Date value2) {
            addCriterion("node_time between", value1, value2, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andNodeTimeNotBetween(Date value1, Date value2) {
            addCriterion("node_time not between", value1, value2, "nodeTime");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table node
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table node
     *
     * @mbggenerated
     */
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