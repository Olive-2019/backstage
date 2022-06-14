package com.backstage.controller;

import com.backstage.dao.BarrageMapper;
import com.backstage.dao.User_commentMapper;
import com.backstage.dao.User_likeMapper;
import com.backstage.dao.VideoMapper;
import com.backstage.pojo.User_comment;
import com.backstage.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("Video")
@CrossOrigin("http://localhost:63342")
public class Video_Controller {
    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BarrageMapper barrageMapper;

    @Autowired
    private User_commentMapper user_commentMapper;

    @Autowired
    private User_likeMapper user_likeMapper;


    @RequestMapping("get_video_num")
    public int get_video_num() {
        return videoMapper.get_video_num();
    }

    @RequestMapping("get_all_videos")
    public Video[] get_all_videos() {
        return videoMapper.get_all_videos();
    }

    @RequestMapping("delete_video")
    public void delete_video(int videoid) {
        videoMapper.delete_video_by_videoid(videoid);
    }
    @RequestMapping("get_video_uploadtime_month")
    public String[][] get_video_uploadtime_month() {
        String[][] ans = new String[2][];
        ans[0] = videoMapper.get_uploadtime();
        Vector<String> tmp = new Vector<String>();
        for (String uploadtime:ans[0]) {
            Integer cnt =
            videoMapper.get_count(uploadtime);
            tmp.add(cnt.toString());
        }
        ans[1] = new String[tmp.size()];
        int i = 0;
        for (String t : tmp) {
            ans[1][i] = t;
            i++;
        }
        return ans;
    }

    @RequestMapping("get_video_bar_num")
    Integer[][] get_video_bar_num() {
        Integer[] video_id = videoMapper.get_all_video_id();
        Integer[] bar_num = new Integer[video_id.length];
        Integer[] comment_num = new Integer[video_id.length];
        Integer[] like_num = new Integer[video_id.length];
        int i = 0;
        for (Integer id : video_id) {
            bar_num[i] = barrageMapper.get_barrage_num_by_id(id);
            i++;
        }
        i = 0;
        for (Integer id : video_id) {
            comment_num[i] = user_commentMapper.get_comment_counter(0, id);
            i++;
        }
        i = 0;
        for (Integer id : video_id) {
            like_num[i] = user_likeMapper.select_like_count(0, id);
            i++;
        }
        Integer[][] ret = new Integer[4][];
        ret[0] = video_id;
        ret[1] = bar_num;
        ret[2] = comment_num;
        ret[3] = like_num;
        return ret;
    }

}
