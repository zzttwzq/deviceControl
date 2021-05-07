package com.qlzw.smartwc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Api_link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 记录ID 
    private Integer user_id; // 用户id 
    private Integer api_id; // api id 
    private Timestamp create_at; // 创建于 
    private Timestamp update_at; // 更新于 
    private Timestamp delete_at; // 删除于 

    public Api_link(Long id,Integer user_id,Integer api_id,Timestamp create_at,Timestamp update_at,Timestamp delete_at) {
        this.id=id;
        this.user_id=user_id;
        this.api_id=api_id;
        this.create_at=create_at;
        this.update_at=update_at;
        this.delete_at=delete_at;
    }

    public Api_link() {}

    public Long getId () { return this.id;}

    public Integer getUser_id () { return this.user_id;}

    public Integer getApi_id () { return this.api_id;}

    public Timestamp getCreate_at () { return this.create_at;}

    public Timestamp getUpdate_at () { return this.update_at;}

    public Timestamp getDelete_at () { return this.delete_at;}

    public void setId (Long id) { this.id = id;}

    public void setUser_id (Integer user_id) { this.user_id = user_id;}

    public void setApi_id (Integer api_id) { this.api_id = api_id;}

    public void setCreate_at (Timestamp create_at) { this.create_at = create_at;}

    public void setUpdate_at (Timestamp update_at) { this.update_at = update_at;}

    public void setDelete_at (Timestamp delete_at) { this.delete_at = delete_at;}

    public String toString() {

        return " <Api_link> {id = " + id + ", " +
                "user_id = " + user_id + ", " +
                "api_id = " + api_id + ", " +
                "create_at = " + create_at + ", " +
                "update_at = " + update_at + ", " +
                "delete_at = " + delete_at + ", " + "}";
    }
}