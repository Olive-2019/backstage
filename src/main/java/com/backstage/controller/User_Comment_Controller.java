package com.backstage.controller;

import com.backstage.dao.User_commentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("User_Comment")
@CrossOrigin("http://localhost:63342")
public class User_Comment_Controller {
    @Autowired
    private User_commentMapper user_commentMapper;

    @RequestMapping("get_user_comment_num")
    public int get_user_comment_num() {
        return user_commentMapper.get_comment_num();
    }
}
