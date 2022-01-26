package com.backstage.controller;

import com.backstage.dao.UserinfoMapper;
import com.backstage.pojo.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Userinfo")
@CrossOrigin("http://localhost:63342")
public class Userinfo_Controller {
    @Autowired
    private UserinfoMapper userinfoMapper;

    @RequestMapping("get_user_num")
    public int get_user_num() {
        return userinfoMapper.get_user_num();
    }

    @RequestMapping("get_all_user")
    public Userinfo[] get_all_user() {
        return userinfoMapper.get_all_user();
    }

    @RequestMapping("delete_user")
    public void delete_user(String username) {
        userinfoMapper.delete_user(username);
    }
}
