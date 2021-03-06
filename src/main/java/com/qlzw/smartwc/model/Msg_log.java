package com.qlzw.smartwc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Msg_log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 记录ID 
    private String snno; // 设备snno 
    private String method; // 上报方法 
    private String sendto; // 接受对象 
    private String params; // 参数 
    private Timestamp create_at; // 创建于 
    private Timestamp update_at; // 更新于 
    private Timestamp delete_at; // 删除于 

    public Msg_log(Long id,String snno,String method,String sendto,String params,Timestamp create_at,Timestamp update_at,Timestamp delete_at) {
        this.id=id;
        this.snno=snno;
        this.method=method;
        this.sendto=sendto;
        this.params=params;
        this.create_at=create_at;
        this.update_at=update_at;
        this.delete_at=delete_at;
    }

    public Msg_log() {}

    public Long getId () { return this.id;}

    public String getSnno () { return this.snno;}

    public String getMethod () { return this.method;}

    public String getSendto () { return this.sendto;}

    public String getParams () { return this.params;}

    public Timestamp getCreate_at () { return this.create_at;}

    public Timestamp getUpdate_at () { return this.update_at;}

    public Timestamp getDelete_at () { return this.delete_at;}

    public void setId (Long id) { this.id = id;}

    public void setSnno (String snno) { this.snno = snno;}

    public void setMethod (String method) { this.method = method;}

    public void setSendto (String sendto) { this.sendto = sendto;}

    public void setParams (String params) { this.params = params;}

    public void setCreate_at (Timestamp create_at) { this.create_at = create_at;}

    public void setUpdate_at (Timestamp update_at) { this.update_at = update_at;}

    public void setDelete_at (Timestamp delete_at) { this.delete_at = delete_at;}

    public String toString() {

        return " <Msg_log> {id = " + id + ", " +
                "snno = " + snno + ", " +
                "snno = '" + snno + "', " +
                "method = " + method + ", " +
                "method = '" + method + "', " +
                "sendto = " + sendto + ", " +
                "sendto = '" + sendto + "', " +
                "params = " + params + ", " +
                "params = '" + params + "', " +
                "create_at = " + create_at + ", " +
                "update_at = " + update_at + ", " +
                "delete_at = " + delete_at + ", " + "}";
    }
}