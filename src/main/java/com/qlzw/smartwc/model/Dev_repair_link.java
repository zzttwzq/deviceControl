package com.qlzw.smartwc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Dev_repair_link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 记录ID 
    private Integer admin_user_id; // 关联的用户id 
    private Integer repair_id; // 关联的维修id 
    private Integer status; // 操作状态 
    private Timestamp create_at; // 创建于 
    private Timestamp update_at; // 更新于 
    private Timestamp delete_at; // 删除于 

    public Dev_repair_link(Long id,Integer admin_user_id,Integer repair_id,Integer status,Timestamp create_at,Timestamp update_at,Timestamp delete_at) {
        this.id=id;
        this.admin_user_id=admin_user_id;
        this.repair_id=repair_id;
        this.status=status;
        this.create_at=create_at;
        this.update_at=update_at;
        this.delete_at=delete_at;
    }

    public Dev_repair_link() {}

    public Long getId () { return this.id;}

    public Integer getAdmin_user_id () { return this.admin_user_id;}

    public Integer getRepair_id () { return this.repair_id;}

    public Integer getStatus () { return this.status;}

    public Timestamp getCreate_at () { return this.create_at;}

    public Timestamp getUpdate_at () { return this.update_at;}

    public Timestamp getDelete_at () { return this.delete_at;}

    public void setId (Long id) { this.id = id;}

    public void setAdmin_user_id (Integer admin_user_id) { this.admin_user_id = admin_user_id;}

    public void setRepair_id (Integer repair_id) { this.repair_id = repair_id;}

    public void setStatus (Integer status) { this.status = status;}

    public void setCreate_at (Timestamp create_at) { this.create_at = create_at;}

    public void setUpdate_at (Timestamp update_at) { this.update_at = update_at;}

    public void setDelete_at (Timestamp delete_at) { this.delete_at = delete_at;}

    public String toString() {

        return " <Dev_repair_link> {id = " + id + ", " +
                "admin_user_id = " + admin_user_id + ", " +
                "repair_id = " + repair_id + ", " +
                "status = " + status + ", " +
                "create_at = " + create_at + ", " +
                "update_at = " + update_at + ", " +
                "delete_at = " + delete_at + ", " + "}";
    }
}