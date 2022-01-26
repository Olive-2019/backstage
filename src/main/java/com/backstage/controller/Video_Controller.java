package com.backstage.controller;

import com.backstage.dao.VideoMapper;
import com.backstage.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Video")
@CrossOrigin("http://localhost:63342")
public class Video_Controller {
    @Autowired
    private VideoMapper videoMapper;

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

}
