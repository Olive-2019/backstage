package com.backstage.pojo;

public class User_comment {

    private Integer commentid;

    private String username;

    private String content;

    private Integer commenttype;

    private Integer commenttoid;

    public User_comment(Integer commentid, String username, String content,
                        Integer commenttype, Integer commenttoid) {
        this.commentid = commentid;
        this.username = username;
        this.content = content;
        this.commenttype = commenttype;
        this.commenttoid = commenttoid;
    }
    public User_comment() {}
    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getCommenttype() {
        return commenttype;
    }

    public void setCommenttype(Integer commenttype) {
        this.commenttype = commenttype;
    }

    public Integer getCommenttoid() {
        return commenttoid;
    }

    public void setCommenttoid(Integer commenttoid) {
        this.commenttoid = commenttoid;
    }
}