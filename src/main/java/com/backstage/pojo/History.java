package com.backstage.pojo;

import java.util.Date;

public class History {

    private String username;

    private Integer videoid;

    private Date time;

    private Integer his;

    private Integer finish;

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish){
        this.finish=finish;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getHis() {
        return his;
    }

    public void setHis(Integer his) {
        this.his = his;
    }
}