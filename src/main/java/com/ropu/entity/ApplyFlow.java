package com.ropu.entity;

import com.ropu.base.dao.BaseEntity;

import java.util.Date;

/**
 * 申请流程
 * Created by jaseeka
 * date 2015/7/20
 * time 15:40
 */
public class ApplyFlow extends BaseEntity {

    private Integer id;

    private String name;

    private String img;

    private Date time;

    private String content;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
}
