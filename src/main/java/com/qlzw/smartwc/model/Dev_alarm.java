package com.qlzw.smartwc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Dev_alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 记录ID 
    private String snno; // 设备snno 
    private String method; // 上报方法 
    private String alarmnumber; // 错误代码 
    private Timestamp create_at; // 创建于 
    private Timestamp update_at; // 更新于 
    private Timestamp delete_at; // 删除于 

    public Dev_alarm(Long id,String snno,String method,String alarmnumber,Timestamp create_at,Timestamp update_at,Timestamp delete_at) {
        this.id=id;
        this.snno=snno;
        this.method=method;
        this.alarmnumber=alarmnumber;
        this.create_at=create_at;
        this.update_at=update_at;
        this.delete_at=delete_at;
    }

    public Dev_alarm() {}

    public Long getId () { return this.id;}

    public String getSnno () { return this.snno;}

    public String getMethod () { return this.method;}

    public String getAlarmnumber () { return this.alarmnumber;}

    public Timestamp getCreate_at () { return this.create_at;}

    public Timestamp getUpdate_at () { return this.update_at;}

    public Timestamp getDelete_at () { return this.delete_at;}

    public void setId (Long id) { this.id = id;}

    public void setSnno (String snno) { this.snno = snno;}

    public void setMethod (String method) { this.method = method;}

    public void setAlarmnumber (String alarmnumber) { this.alarmnumber = alarmnumber;}

    public void setCreate_at (Timestamp create_at) { this.create_at = create_at;}

    public void setUpdate_at (Timestamp update_at) { this.update_at = update_at;}

    public void setDelete_at (Timestamp delete_at) { this.delete_at = delete_at;}

    public String toString() {

        return " <Dev_alarm> {id = " + id + ", " +
                "snno = " + snno + ", " +
                "snno = '" + snno + "', " +
                "method = " + method + ", " +
                "method = '" + method + "', " +
                "alarmnumber = " + alarmnumber + ", " +
                "alarmnumber = '" + alarmnumber + "', " +
                "create_at = " + create_at + ", " +
                "update_at = " + update_at + ", " +
                "delete_at = " + delete_at + ", " + "}";
    }
}