package com.qlzw.smartwc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Dev_update {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 记录ID 
    private Integer dev_id; // 设备id 
    private String snno; // 设备编号 
    private Integer status; // 设备升级状态 
    private String ipaddress; // 客户端ip 
    private String hrev; // 硬件版本 
    private String srev; // 软件版本 
    private Timestamp create_at; // 创建于 
    private Timestamp update_at; // 更新于 
    private Timestamp delete_at; // 删除于 

    public Dev_update(Long id,Integer dev_id,String snno,Integer status,String ipaddress,String hrev,String srev,Timestamp create_at,Timestamp update_at,Timestamp delete_at) {
        this.id=id;
        this.dev_id=dev_id;
        this.snno=snno;
        this.status=status;
        this.ipaddress=ipaddress;
        this.hrev=hrev;
        this.srev=srev;
        this.create_at=create_at;
        this.update_at=update_at;
        this.delete_at=delete_at;
    }

    public Dev_update() {}

    public Long getId () { return this.id;}

    public Integer getDev_id () { return this.dev_id;}

    public String getSnno () { return this.snno;}

    public Integer getStatus () { return this.status;}

    public String getIpaddress () { return this.ipaddress;}

    public String getHrev () { return this.hrev;}

    public String getSrev () { return this.srev;}

    public Timestamp getCreate_at () { return this.create_at;}

    public Timestamp getUpdate_at () { return this.update_at;}

    public Timestamp getDelete_at () { return this.delete_at;}

    public void setId (Long id) { this.id = id;}

    public void setDev_id (Integer dev_id) { this.dev_id = dev_id;}

    public void setSnno (String snno) { this.snno = snno;}

    public void setStatus (Integer status) { this.status = status;}

    public void setIpaddress (String ipaddress) { this.ipaddress = ipaddress;}

    public void setHrev (String hrev) { this.hrev = hrev;}

    public void setSrev (String srev) { this.srev = srev;}

    public void setCreate_at (Timestamp create_at) { this.create_at = create_at;}

    public void setUpdate_at (Timestamp update_at) { this.update_at = update_at;}

    public void setDelete_at (Timestamp delete_at) { this.delete_at = delete_at;}

    public String toString() {

        return " <Dev_update> {id = " + id + ", " +
                "dev_id = " + dev_id + ", " +
                "snno = " + snno + ", " +
                "snno = '" + snno + "', " +
                "status = " + status + ", " +
                "ipaddress = " + ipaddress + ", " +
                "ipaddress = '" + ipaddress + "', " +
                "hrev = " + hrev + ", " +
                "hrev = '" + hrev + "', " +
                "srev = " + srev + ", " +
                "srev = '" + srev + "', " +
                "create_at = " + create_at + ", " +
                "update_at = " + update_at + ", " +
                "delete_at = " + delete_at + ", " + "}";
    }
}