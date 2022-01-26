package com.backstage.pojo;

public class Field {

    private Integer fieldid;

    private String fieldname;

    public Integer getFieldid() {
        return fieldid;
    }

    public void setFieldid(Integer fieldid) {
        this.fieldid = fieldid;
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname == null ? null : fieldname.trim();
    }
}