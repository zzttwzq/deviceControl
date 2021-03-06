package com.qlzw.smartwc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Dev_cmd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 记录ID 
    private String snno; // 设备snno 
    private String method; // 上报方法 
    private String params; // 参数 
    private Integer ischecked; // 是否已经收到应答 
    private Integer isouttime; // 是否过期 
    private Timestamp create_at; // 创建于 
    private Timestamp update_at; // 更新于 
    private Timestamp delete_at; // 删除于 

    public Dev_cmd(Long id,String snno,String method,String params,Integer ischecked,Integer isouttime,Timestamp create_at,Timestamp update_at,Timestamp delete_at) {
        this.id=id;
        this.snno=snno;
        this.method=method;
        this.params=params;
        this.ischecked=ischecked;
        this.isouttime=isouttime;
        this.create_at=create_at;
        this.update_at=update_at;
        this.delete_at=delete_at;
    }

    public Dev_cmd() {}

    public Long getId () { return this.id;}

    public String getSnno () { return this.snno;}

    public String getMethod () { return this.method;}

    public String getParams () { return this.params;}

    public Integer getIschecked () { return this.ischecked;}

    public Integer getIsouttime () { return this.isouttime;}

    public Timestamp getCreate_at () { return this.create_at;}

    public Timestamp getUpdate_at () { return this.update_at;}

    public Timestamp getDelete_at () { return this.delete_at;}

    public void setId (Long id) { this.id = id;}

    public void setSnno (String snno) { this.snno = snno;}

    public void setMethod (String method) { this.method = method;}

    public void setParams (String params) { this.params = params;}

    public void setIschecked (Integer ischecked) { this.ischecked = ischecked;}

    public void setIsouttime (Integer isouttime) { this.isouttime = isouttime;}

    public void setCreate_at (Timestamp create_at) { this.create_at = create_at;}

    public void setUpdate_at (Timestamp update_at) { this.update_at = update_at;}

    public void setDelete_at (Timestamp delete_at) { this.delete_at = delete_at;}

    public String toString() {

        return " <Dev_cmd> {id = " + id + ", " +
                "snno = " + snno + ", " +
                "snno = '" + snno + "', " +
                "method = " + method + ", " +
                "method = '" + method + "', " +
                "params = " + params + ", " +
                "params = '" + params + "', " +
                "ischecked = " + ischecked + ", " +
                "isouttime = " + isouttime + ", " +
                "create_at = " + create_at + ", " +
                "update_at = " + update_at + ", " +
                "delete_at = " + delete_at + ", " + "}";
    }
}