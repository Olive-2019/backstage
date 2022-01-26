package com.backstage.controller;

import com.backstage.dao.UserinfoMapper;
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
}
