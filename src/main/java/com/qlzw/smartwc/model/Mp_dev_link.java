package com.qlzw.smartwc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Mp_dev_link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 记录ID 
    private Integer mp_user_id; // 小程序用户id 
    private Integer dev_id; // 设备id 
    private Integer status; // 状态 0：取消关联 1：建立关联 
    private Timestamp create_at; // 创建于 
    private Timestamp update_at; // 更新于 
    private Timestamp delete_at; // 删除于 

    public Mp_dev_link(Long id,Integer mp_user_id,Integer dev_id,Integer status,Timestamp create_at,Timestamp update_at,Timestamp delete_at) {
        this.id=id;
        this.mp_user_id=mp_user_id;
        this.dev_id=dev_id;
        this.status=status;
        this.create_at=create_at;
        this.update_at=update_at;
        this.delete_at=delete_at;
    }

    public Mp_dev_link() {}

    public Long getId () { return this.id;}

    public Integer getMp_user_id () { return this.mp_user_id;}

    public Integer getDev_id () { return this.dev_id;}

    public Integer getStatus () { return this.status;}

    public Timestamp getCreate_at () { return this.create_at;}

    public Timestamp getUpdate_at () { return this.update_at;}

    public Timestamp getDelete_at () { return this.delete_at;}

    public void setId (Long id) { this.id = id;}

    public void setMp_user_id (Integer mp_user_id) { this.mp_user_id = mp_user_id;}

    public void setDev_id (Integer dev_id) { this.dev_id = dev_id;}

    public void setStatus (Integer status) { this.status = status;}

    public void setCreate_at (Timestamp create_at) { this.create_at = create_at;}

    public void setUpdate_at (Timestamp update_at) { this.update_at = update_at;}

    public void setDelete_at (Timestamp delete_at) { this.delete_at = delete_at;}

    public String toString() {

        return " <Mp_dev_link> {id = " + id + ", " +
                "mp_user_id = " + mp_user_id + ", " +
                "dev_id = " + dev_id + ", " +
                "status = " + status + ", " +
                "create_at = " + create_at + ", " +
                "update_at = " + update_at + ", " +
                "delete_at = " + delete_at + ", " + "}";
    }
}