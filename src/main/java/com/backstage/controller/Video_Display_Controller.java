package com.backstage.controller;

import com.backstage.dao.*;
import com.backstage.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("video_Display_Page")
@CrossOrigin("http://localhost:63342")  //跨域必要
public class Video_Display_Controller {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private User_likeMapper user_likeMapper;

    @Autowired
    private  BarrageMapper barrageMapper;

    @RequestMapping("get_hot_videos")
    public  Video[] get_hot_videos() {
        /**
         * @ param     :
         * @ return    :点赞数前10的视频
         * @ Description:获取热门视频
         */

        Video[] ret = videoMapper.select_hot_videos();
        return ret;
    }

    @RequestMapping("get_video_info")
    public Video get_video_info(int videoID) {
        return videoMapper.selectByPrimaryKey(videoID);
    }

    @RequestMapping("get_author_info")
    public Userinfo get_author_info(String username) {
        return userinfoMapper.selectByPrimaryKey(username);
    }

    @RequestMapping("get_video_by_search")
    public Video[] get_video_by_search(String request){
        return videoMapper.get_videos_by_search(request);
    }


//    public abstract int comment(String username, int comment_to_ID, commentType type, String content);
    @RequestMapping("get_barrage")
    public Barrage[] get_barrage(int videoID){
        return barrageMapper.get_barrage_by_video(videoID);
    }

    @RequestMapping("new_barrage")
    public int new_barrage(Barrage barrage){
        System.out.println("new barrage");
        int nextID=barrageMapper.get_barrage_ID();
        barrage.setBarrageid(nextID);
        System.out.println("barrage construction");
        System.out.println(barrage.getBarrageid()+"  "+barrage.getContent()+
                "  "+barrage.getTime()+"  "+barrage.getUsername()+"  "+barrage.getVideoid());
        return barrageMapper.insert(barrage);
    }

    @RequestMapping("get_video_by_field")
    public Video[] get_video_by_field(int fieldID){
        return videoMapper.get_videos_by_field(fieldID);
    }


}
