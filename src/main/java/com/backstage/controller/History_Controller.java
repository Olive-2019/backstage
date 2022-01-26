package com.backstage.controller;
import com.backstage.dao.*;
import com.backstage.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("history")
@CrossOrigin("http://localhost:63342")
public class History_Controller {
    @Autowired
    private HistoryMapper historyMapper;
    @Autowired
    private User_likeMapper user_likeMapper;
    @Autowired
    private BarrageMapper barrageMapper;

    @RequestMapping("get_watches")
    public int[] get_watches(){
        long daytime=1*24*60*60*1000;

        Date today=new Date(System.currentTimeMillis());
        Date yesterday=new Date(today.getTime()-daytime);
        int [] ret= new int[10];
        for(int i=0;i<10;i++){
            ret[i]=historyMapper.get_watches(yesterday.toLocalDate(),today.toLocalDate());
            today=yesterday;
            yesterday=new Date(today.getTime()-daytime);
        }
        return ret;
    }
    @RequestMapping("get_data_by_ID")
    public int[] get_data_by_ID(int videoID){
        int[] ret=new int[3];
        ret[0]=historyMapper.get_watches_by_ID(videoID);
        ret[1]=user_likeMapper.select_like_count(0,videoID);
        Barrage[] temp=barrageMapper.get_barrage_by_video(videoID);
        ret[2]=temp.length;
        return ret;
    }
}
