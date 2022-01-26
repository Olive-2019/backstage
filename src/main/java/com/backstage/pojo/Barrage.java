package com.backstage.pojo;

public class Barrage {

    private Integer barrageid;

    private String username;

    private Integer videoid;

    private String content;

    private Integer time;

    public Integer getBarrageid() {
        return barrageid;
    }


    public void setBarrageid(Integer barrageid) {
        this.barrageid = barrageid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getVideoid() {
        return videoid;
    }

    public void setVideoid(Integer videoid) {
        this.videoid = videoid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}