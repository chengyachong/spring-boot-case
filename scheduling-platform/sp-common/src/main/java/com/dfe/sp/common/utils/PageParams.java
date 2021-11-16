package com.dfe.sp.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class PageParams {
    public static void setpageParams(Map<String, Object> params) {
        if(params.get("pageNum") == null || StringUtils.isBlank(String.valueOf(params.get("pageNum")))) {
            params.put("pageNum","1");
        }
        if(params.get("pageSize") == null || StringUtils.isBlank(String.valueOf(params.get("pageSize")))) {
            params.put("pageSize","20");
        }
        int pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));
        int pageSize = Integer.parseInt(String.valueOf(params.get("pageSize")));
        if(pageNum <=0) {
            pageNum = 1;
        }
        if(pageSize <= 0) {
            pageSize = 20;
        }
        int startRow = (pageNum-1) * pageSize;
        params.put("startRow",startRow+"");
    }

    public static String orgPageSql(StringBuffer sql,Map<String,Object> params,String dbType) {
        if(StringUtils.isNotBlank(String.valueOf(params.get("startRow"))) && StringUtils.isNotBlank(String.valueOf(params.get("pageSize")))) {
            if("informix".equals(dbType)) {
                sql.insert(6," skip #{startRow} first #{pageSize} ");
            } else {
                sql.append(" limit #{startRow}, #{pageSize}");
            }
        }
        return sql.toString();
    }

    public static String orgPageSql(StringBuffer sql,int startRow,int pageSize, String dbType) {
        if(dbType.contains("informix")) {
            String s = " skip " + startRow + " first " + pageSize;
            sql.insert(6,s);
        } else {
            sql.append(" limit "+startRow+","+pageSize);
        }
        return sql.toString();
    }
}
