package com.qlzw.smartwc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Admin_link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 记录ID 
    private Integer parent_admin_id; // 关联账户id 
    private Integer area_id; // 关联账户区域id 
    private Integer admin_id; // 账户id 
    private Integer status; // 状态 0：取消关联 1：建立关联 
    private Timestamp create_at; // 创建于 
    private Timestamp update_at; // 更新于 
    private Timestamp delete_at; // 删除于 

    public Admin_link(Long id,Integer parent_admin_id,Integer area_id,Integer admin_id,Integer status,Timestamp create_at,Timestamp update_at,Timestamp delete_at) {
        this.id=id;
        this.parent_admin_id=parent_admin_id;
        this.area_id=area_id;
        this.admin_id=admin_id;
        this.status=status;
        this.create_at=create_at;
        this.update_at=update_at;
        this.delete_at=delete_at;
    }

    public Admin_link() {}

    public Long getId () { return this.id;}

    public Integer getParent_admin_id () { return this.parent_admin_id;}

    public Integer getArea_id () { return this.area_id;}

    public Integer getAdmin_id () { return this.admin_id;}

    public Integer getStatus () { return this.status;}

    public Timestamp getCreate_at () { return this.create_at;}

    public Timestamp getUpdate_at () { return this.update_at;}

    public Timestamp getDelete_at () { return this.delete_at;}

    public void setId (Long id) { this.id = id;}

    public void setParent_admin_id (Integer parent_admin_id) { this.parent_admin_id = parent_admin_id;}

    public void setArea_id (Integer area_id) { this.area_id = area_id;}

    public void setAdmin_id (Integer admin_id) { this.admin_id = admin_id;}

    public void setStatus (Integer status) { this.status = status;}

    public void setCreate_at (Timestamp create_at) { this.create_at = create_at;}

    public void setUpdate_at (Timestamp update_at) { this.update_at = update_at;}

    public void setDelete_at (Timestamp delete_at) { this.delete_at = delete_at;}

    public String toString() {

        return " <Admin_link> {id = " + id + ", " +
                "parent_admin_id = " + parent_admin_id + ", " +
                "area_id = " + area_id + ", " +
                "admin_id = " + admin_id + ", " +
                "status = " + status + ", " +
                "create_at = " + create_at + ", " +
                "update_at = " + update_at + ", " +
                "delete_at = " + delete_at + ", " + "}";
    }
}