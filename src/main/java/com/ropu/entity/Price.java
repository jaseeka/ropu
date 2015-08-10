package com.ropu.entity;

import com.ropu.base.dao.BaseEntity;

import java.util.Date;

/**
 * 报价信息
 * Created by jaseeka
 * Date 2015/8/10
 * Time 23:43
 */
public class Price extends BaseEntity {

    private Integer id;

    private String title;

    private Date time;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
