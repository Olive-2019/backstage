package com.backstage.controller;
import com.backstage.dao.UserinfoMapper;
import com.backstage.pojo.*;
import com.backstage.dao.*;
import com.backstage.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("Userinfo")
@CrossOrigin("http://localhost:63342")
public class Userinfo_Controller {
    @Autowired
    private UserinfoMapper userinfoMapper;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private HistoryMapper historyMapper;
    @Autowired
    private User_likeMapper user_likeMapper;
    @RequestMapping("get_user_num")
    public int get_user_num() {
        return userinfoMapper.get_user_num();
    }
//    @RequestMapping("get_hot_author")
//    public String[] get_hot_author(){
//        return userinfoMapper.get_hot_user();
//    }
    @RequestMapping("get_author_info")
    public int[] get_author_info(String username){
        int[] ret=new int[3];
        Video[] temp1=videoMapper.get_videos_by_username(username);
        ret[0]=temp1.length;
        ret[1]=historyMapper.get_history_num_by_username(username);
        ret[2]=user_likeMapper.select_like_num_by_username(username);
        return ret;
    }

    @RequestMapping("get_all_user")
    public Userinfo[] get_all_user() {
        return userinfoMapper.get_all_user();
    }

    @RequestMapping("delete_user")
    public void delete_user(String username) {
        userinfoMapper.delete_user(username);
    }

    @RequestMapping("get_percents")
    public int[] get_percents(){
        int[] ret=new int[4];
        int his_num=historyMapper.get_history_num();
        if (his_num != 0) ret[0]=100*user_likeMapper.get_like_num()/his_num;
        int ups=videoMapper.get_up_num();
        int users=userinfoMapper.get_user_num();
        if (users != 0) ret[1]=100*ups/users;
        int finishes=historyMapper.get_finish_history_num();
        ret[2]=100*finishes/his_num;
        Date time=new Date(System.currentTimeMillis());
        long daytime=1*24*60*60*1000;
        Date last_week=new Date(time.getTime()-daytime*7);
        int active_user_num=historyMapper.get_active_user_num(last_week.toLocalDate());
        if (users != 0) ret[3]=100*active_user_num/users;
        return ret;
    }

}

