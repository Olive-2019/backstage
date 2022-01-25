package com.backstage.pojo;

public class User_like {

    private String username;


    private Integer likeid;

    private Integer liketype;

    public User_like(){}

    public User_like(String username, int likeid, int liketype) {
        this.username = username;
        this.likeid = likeid;
        this.liketype = liketype;
    }
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getLikeid() {
        return likeid;
    }

    public void setLikeid(Integer likeid) {
        this.likeid = likeid;
    }

    public Integer getLiketype() {
        return liketype;
    }

    public void setLiketype(Integer liketype) {
        this.liketype = liketype;
    }
}