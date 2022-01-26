package com.backstage.controller;

import com.backstage.dao.*;
import com.backstage.pojo.History;
import com.backstage.pojo.Video;
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
    @Autowired
    private HistoryMapper historyMapper;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private User_likeMapper user_likeMapper;

    @RequestMapping("get_user_num")
    public int get_user_num() {
        return userinfoMapper.get_user_num();
    }
    @RequestMapping("get_hot_author")
    public String[] get_hot_author(){
        return userinfoMapper.get_hot_user();
    }
    @RequestMapping("get_author_info")
    public int[] get_author_info(String username){
        int[] ret=new int[3];
        Video[] temp1=videoMapper.get_videos_by_username(username);
        ret[0]=temp1.length;
        ret[1]=historyMapper.get_history_num_by_username(username);
        ret[2]=user_likeMapper.select_like_num_by_username(username);
        return ret;
    }

}