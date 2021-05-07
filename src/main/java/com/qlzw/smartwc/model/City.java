package com.qlzw.smartwc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 记录ID 
    private Integer code; // 对应代码 
    private Integer province_code; // 所属省份 
    private String name; // 名称 
    private Timestamp create_at; // 创建于 
    private Timestamp update_at; // 更新于 
    private Timestamp delete_at; // 删除于 

    public City(Long id,Integer code,Integer province_code,String name,Timestamp create_at,Timestamp update_at,Timestamp delete_at) {
        this.id=id;
        this.code=code;
        this.province_code=province_code;
        this.name=name;
        this.create_at=create_at;
        this.update_at=update_at;
        this.delete_at=delete_at;
    }

    public City() {}

    public Long getId () { return this.id;}

    public Integer getCode () { return this.code;}

    public Integer getProvince_code () { return this.province_code;}

    public String getName () { return this.name;}

    public Timestamp getCreate_at () { return this.create_at;}

    public Timestamp getUpdate_at () { return this.update_at;}

    public Timestamp getDelete_at () { return this.delete_at;}

    public void setId (Long id) { this.id = id;}

    public void setCode (Integer code) { this.code = code;}

    public void setProvince_code (Integer province_code) { this.province_code = province_code;}

    public void setName (String name) { this.name = name;}

    public void setCreate_at (Timestamp create_at) { this.create_at = create_at;}

    public void setUpdate_at (Timestamp update_at) { this.update_at = update_at;}

    public void setDelete_at (Timestamp delete_at) { this.delete_at = delete_at;}

    public String toString() {

        return " <City> {id = " + id + ", " +
                "code = " + code + ", " +
                "province_code = " + province_code + ", " +
                "name = " + name + ", " +
                "name = '" + name + "', " +
                "create_at = " + create_at + ", " +
                "update_at = " + update_at + ", " +
                "delete_at = " + delete_at + ", " + "}";
    }
}