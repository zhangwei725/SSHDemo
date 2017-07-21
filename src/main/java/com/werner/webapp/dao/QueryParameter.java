package com.werner.webapp.dao;


import java.util.Map;

public class QueryParameter {
    public static final String PARAM_KEY_INSETER = "insert";

    public String parameterName;
    public Object ParameterValue;
    private QueryOperateType ParameterType;
    private Map<String, Object> paramsMap;

    public Map<String, Object> getParamsMap() {
        return paramsMap;
    }

    public void setParamsMap(Map<String, Object> paramsMap) {
        this.paramsMap = paramsMap;
    }

    public enum QueryOperateType {
        Equal, CharIn
    }


    public QueryParameter() {

    }

    public QueryParameter(String parameterName, Object parameterValue,
                          QueryOperateType parameterType) {
        this.parameterName = parameterName;
        this.ParameterValue = parameterValue;
        this.ParameterType = parameterType;
    }

    public String getParameterName() {
        return parameterName;
    }

    public QueryOperateType getParameterType() {
        return ParameterType;
    }

    public Object getParameterValue() {
        return ParameterValue;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public void setParameterType(QueryOperateType parameterType) {
        this.ParameterType = parameterType;
    }

    public void setParameterValue(Object parameterValue) {
        ParameterValue = parameterValue;
    }
}