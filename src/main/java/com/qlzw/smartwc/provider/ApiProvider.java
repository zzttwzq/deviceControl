package com.qlzw.smartwc.provider;

import com.qlzw.smartwc.utils.Pager;
import com.qlzw.smartwc.model.Api;
import java.util.Map;

public class ApiProvider {

    public String selectAll(Map<String, Object> parm) {

        return "select id,name,router,create_at,update_at,delete_at from api limit #{page},#{size}";
    }

    public String selectOne() {

        return "select id,name,router,create_at,update_at,delete_at from api where api.id=#{id}";
    }

    public String deleteOne() {

        return "delete from api where id = #{id}";
    }

    public String insertOne(Api api) {

        String key = "";
        String value = "";
        if (api.getId() != null && api.getId() > 0) {
           key += "id,";
           value += "#{id},";
        }

        if (api.getName() != null && !api.getName().isEmpty()) {
           key += "name,";
           value += "#{name},";
        }

        if (api.getRouter() != null && !api.getRouter().isEmpty()) {
           key += "router,";
           value += "#{router},";
        }

        if (api.getCreate_at() != null) {
           key += "create_at,";
           value += "#{create_at},";
        }

        if (api.getUpdate_at() != null) {
           key += "update_at,";
           value += "#{update_at},";
        }

        if (api.getUpdate_at() != null) {
           key += "delete_at,";
           value += "#{delete_at},";
        }

        key = key.substring(0,key.length()-1);
        value = value.substring(0,value.length()-1);

        return "insert into api (" + key + ") values (" + value + ")";
    }

    public String updateOne(Api api) {

        String sql = "";
        if (api.getId() != null && api.getId() > 0) {
           sql += "id = #{id},";
        }

        if (api.getName() != null && !api.getName().isEmpty()) {
           sql += "name = #{name},";
        }

        if (api.getRouter() != null && !api.getRouter().isEmpty()) {
           sql += "router = #{router},";
        }

        if (api.getCreate_at() != null) {
           sql += "create_at = #{create_at},";
        }

        if (api.getUpdate_at() != null) {
           sql += "update_at = #{update_at},";
        }

        if (api.getUpdate_at() != null) {
           sql += "delete_at = #{delete_at},";
        }

        sql = sql.substring(0,sql.length()-1);

        return "update api set " + sql + " where id = #{id}";
    }
}
