package com.backstage.pojo;

import java.util.Date;

public class Video {

    private Integer videoid;

    private String description;

    private String title;

    private String videopath;

    private Integer fieldid;

    private Date uploadtime;

    private String uploader;

    private String image;

    public Video() {}

    public Video(Integer videoid, String description, String title, String videopath,
                 Integer fieldid, Date uploadtime, String uploader) {
        this.videoid = videoid;
        this.description = description;
        this.title = title;
        this.videopath = videopath;
        this.fieldid = fieldid;
        this.uploadtime = uploadtime;
        this.uploader = uploader;
    }

    public Integer getVideoid() {
        return videoid;
    }

    public void setVideoid(Integer videoid) {
        this.videoid = videoid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getVideoPath() {
        return videopath;
    }


    public void setVideopath(String videopath) {
        this.videopath = videopath == null ? null : videopath.trim();
    }

    public Integer getFieldid() {
        return fieldid;
    }

    public void setFieldid(Integer fieldid) {
        this.fieldid = fieldid;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader == null ? null : uploader.trim();
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image == null ? null : image.trim();
    }

}