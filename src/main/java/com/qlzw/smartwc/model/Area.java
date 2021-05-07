package com.qlzw.smartwc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 记录ID 
    private String name; // 区域名称 
    private Timestamp create_at; // 创建于 
    private Timestamp update_at; // 更新于 
    private Timestamp delete_at; // 删除于 

    public Area(Long id,String name,Timestamp create_at,Timestamp update_at,Timestamp delete_at) {
        this.id=id;
        this.name=name;
        this.create_at=create_at;
        this.update_at=update_at;
        this.delete_at=delete_at;
    }

    public Area() {}

    public Long getId () { return this.id;}

    public String getName () { return this.name;}

    public Timestamp getCreate_at () { return this.create_at;}

    public Timestamp getUpdate_at () { return this.update_at;}

    public Timestamp getDelete_at () { return this.delete_at;}

    public void setId (Long id) { this.id = id;}

    public void setName (String name) { this.name = name;}

    public void setCreate_at (Timestamp create_at) { this.create_at = create_at;}

    public void setUpdate_at (Timestamp update_at) { this.update_at = update_at;}

    public void setDelete_at (Timestamp delete_at) { this.delete_at = delete_at;}

    public String toString() {

        return " <Area> {id = " + id + ", " +
                "name = " + name + ", " +
                "name = '" + name + "', " +
                "create_at = " + create_at + ", " +
                "update_at = " + update_at + ", " +
                "delete_at = " + delete_at + ", " + "}";
    }
}