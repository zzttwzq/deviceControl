package com.qlzw.smartwc.provider;

import com.qlzw.smartwc.utils.Pager;
import com.qlzw.smartwc.model.Dev_connect;
import java.util.Map;

public class Dev_connectProvider {

    public String selectAll(Map<String, Object> parm) {

        return "select id,snno,method,create_at,update_at,delete_at from dev_connect limit #{page},#{size}";
    }

    public String selectOne() {

        return "select id,snno,method,create_at,update_at,delete_at from dev_connect where dev_connect.id=#{id}";
    }

    public String deleteOne() {

        return "delete from dev_connect where id = #{id}";
    }

    public String insertOne(Dev_connect dev_connect) {

        String key = "";
        String value = "";
        if (dev_connect.getId() != null && dev_connect.getId() > 0) {
           key += "id,";
           value += "#{id},";
        }

        if (dev_connect.getSnno() != null && !dev_connect.getSnno().isEmpty()) {
           key += "snno,";
           value += "#{snno},";
        }

        if (dev_connect.getMethod() != null && !dev_connect.getMethod().isEmpty()) {
           key += "method,";
           value += "#{method},";
        }

        if (dev_connect.getCreate_at() != null) {
           key += "create_at,";
           value += "#{create_at},";
        }

        if (dev_connect.getUpdate_at() != null) {
           key += "update_at,";
           value += "#{update_at},";
        }

        if (dev_connect.getUpdate_at() != null) {
           key += "delete_at,";
           value += "#{delete_at},";
        }

        key = key.substring(0,key.length()-1);
        value = value.substring(0,value.length()-1);

        return "insert into dev_connect (" + key + ") values (" + value + ")";
    }

    public String updateOne(Dev_connect dev_connect) {

        String sql = "";
        if (dev_connect.getId() != null && dev_connect.getId() > 0) {
           sql += "id = #{id},";
        }

        if (dev_connect.getSnno() != null && !dev_connect.getSnno().isEmpty()) {
           sql += "snno = #{snno},";
        }

        if (dev_connect.getMethod() != null && !dev_connect.getMethod().isEmpty()) {
           sql += "method = #{method},";
        }

        if (dev_connect.getCreate_at() != null) {
           sql += "create_at = #{create_at},";
        }

        if (dev_connect.getUpdate_at() != null) {
           sql += "update_at = #{update_at},";
        }

        if (dev_connect.getUpdate_at() != null) {
           sql += "delete_at = #{delete_at},";
        }

        sql = sql.substring(0,sql.length()-1);

        return "update dev_connect set " + sql + " where id = #{id}";
    }
}
