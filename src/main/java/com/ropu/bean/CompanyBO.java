package com.ropu.bean;

import com.ropu.base.dao.BaseEntity;

import java.util.Date;

/**
 * Created by jaseeka
 * date 2015/7/20
 * time 15:21
 */
public class CompanyBO extends BaseEntity {

    private Integer id;

    private String name;

    private Date time;

    private String content;

    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
