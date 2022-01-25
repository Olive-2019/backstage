package com.backstage.pojo;

public class Follow {

    private String usernamefollowed;

    private String usernamefollower;

    public String getUsernamefollowed() {
        return usernamefollowed;
    }

    public void setUsernamefollowed(String usernamefollowed) {
        this.usernamefollowed = usernamefollowed == null ? null : usernamefollowed.trim();
    }

    public String getUsernamefollower() {
        return usernamefollower;
    }

    public void setUsernamefollower(String usernamefollower) {
        this.usernamefollower = usernamefollower == null ? null : usernamefollower.trim();
    }
}