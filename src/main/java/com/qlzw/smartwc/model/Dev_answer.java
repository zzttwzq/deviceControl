package com.qlzw.smartwc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Dev_answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 记录ID 
    private String title; // 问题名称 
    private String cause; // 导致问题的可能原因 
    private String tips; // 维修详情 
    private Timestamp create_at; // 创建于 
    private Timestamp update_at; // 更新于 
    private Timestamp delete_at; // 删除于 

    public Dev_answer(Long id,String title,String cause,String tips,Timestamp create_at,Timestamp update_at,Timestamp delete_at) {
        this.id=id;
        this.title=title;
        this.cause=cause;
        this.tips=tips;
        this.create_at=create_at;
        this.update_at=update_at;
        this.delete_at=delete_at;
    }

    public Dev_answer() {}

    public Long getId () { return this.id;}

    public String getTitle () { return this.title;}

    public String getCause () { return this.cause;}

    public String getTips () { return this.tips;}

    public Timestamp getCreate_at () { return this.create_at;}

    public Timestamp getUpdate_at () { return this.update_at;}

    public Timestamp getDelete_at () { return this.delete_at;}

    public void setId (Long id) { this.id = id;}

    public void setTitle (String title) { this.title = title;}

    public void setCause (String cause) { this.cause = cause;}

    public void setTips (String tips) { this.tips = tips;}

    public void setCreate_at (Timestamp create_at) { this.create_at = create_at;}

    public void setUpdate_at (Timestamp update_at) { this.update_at = update_at;}

    public void setDelete_at (Timestamp delete_at) { this.delete_at = delete_at;}

    public String toString() {

        return " <Dev_answer> {id = " + id + ", " +
                "title = " + title + ", " +
                "title = '" + title + "', " +
                "cause = " + cause + ", " +
                "cause = '" + cause + "', " +
                "tips = " + tips + ", " +
                "tips = '" + tips + "', " +
                "create_at = " + create_at + ", " +
                "update_at = " + update_at + ", " +
                "delete_at = " + delete_at + ", " + "}";
    }
}