package cn.edu.ecnu.domain;

import java.util.ArrayList;
import java.util.List;

public class TeamExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table team
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table team
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table team
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated
     */
    public TeamExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
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
     * This method corresponds to the database table team
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
     * This method corresponds to the database table team
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
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
     * This class corresponds to the database table team
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

        public Criteria andTeamidIsNull() {
            addCriterion("teamid is null");
            return (Criteria) this;
        }

        public Criteria andTeamidIsNotNull() {
            addCriterion("teamid is not null");
            return (Criteria) this;
        }

        public Criteria andTeamidEqualTo(String value) {
            addCriterion("teamid =", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidNotEqualTo(String value) {
            addCriterion("teamid <>", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidGreaterThan(String value) {
            addCriterion("teamid >", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidGreaterThanOrEqualTo(String value) {
            addCriterion("teamid >=", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidLessThan(String value) {
            addCriterion("teamid <", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidLessThanOrEqualTo(String value) {
            addCriterion("teamid <=", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidLike(String value) {
            addCriterion("teamid like", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidNotLike(String value) {
            addCriterion("teamid not like", value, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidIn(List<String> values) {
            addCriterion("teamid in", values, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidNotIn(List<String> values) {
            addCriterion("teamid not in", values, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidBetween(String value1, String value2) {
            addCriterion("teamid between", value1, value2, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamidNotBetween(String value1, String value2) {
            addCriterion("teamid not between", value1, value2, "teamid");
            return (Criteria) this;
        }

        public Criteria andTeamnameIsNull() {
            addCriterion("teamname is null");
            return (Criteria) this;
        }

        public Criteria andTeamnameIsNotNull() {
            addCriterion("teamname is not null");
            return (Criteria) this;
        }

        public Criteria andTeamnameEqualTo(String value) {
            addCriterion("teamname =", value, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameNotEqualTo(String value) {
            addCriterion("teamname <>", value, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameGreaterThan(String value) {
            addCriterion("teamname >", value, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameGreaterThanOrEqualTo(String value) {
            addCriterion("teamname >=", value, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameLessThan(String value) {
            addCriterion("teamname <", value, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameLessThanOrEqualTo(String value) {
            addCriterion("teamname <=", value, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameLike(String value) {
            addCriterion("teamname like", value, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameNotLike(String value) {
            addCriterion("teamname not like", value, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameIn(List<String> values) {
            addCriterion("teamname in", values, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameNotIn(List<String> values) {
            addCriterion("teamname not in", values, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameBetween(String value1, String value2) {
            addCriterion("teamname between", value1, value2, "teamname");
            return (Criteria) this;
        }

        public Criteria andTeamnameNotBetween(String value1, String value2) {
            addCriterion("teamname not between", value1, value2, "teamname");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table team
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
     * This class corresponds to the database table team
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