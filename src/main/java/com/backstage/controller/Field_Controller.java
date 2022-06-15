package com.backstage.controller;

import com.backstage.dao.FieldMapper;
import com.backstage.dao.VideoMapper;
import com.backstage.pojo.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@RestController
@RequestMapping("Field")
@CrossOrigin("http://localhost:63342")
public class Field_Controller {

    @Autowired
    private FieldMapper fieldMapper;

    @Autowired
    private VideoMapper videoMapper;

    @RequestMapping("get_all_fields")
    public Field[] get_all_fields() {

        return fieldMapper.get_all_fields();
    }
    @RequestMapping("get_field_child")
    public HashMap<String, String[]> get_field_child() {
        HashMap<String, String[]> ans = new HashMap<String, String[]>();
        Field[] fields = fieldMapper.get_all_fields();
        for (Field field : fields) {
            String[] child = videoMapper.get_video_title_by_field_id(field.getFieldid());
            ans.put(field.getFieldname(), child);
        }
        return ans;
    }

    @RequestMapping("add_field")
    public synchronized void add_field(Field field) {
        int id = fieldMapper.get_next_id();
        field.setFieldid(id);
        fieldMapper.insert(field);
    }

    @RequestMapping("delete_field")
    public void delete_field(int fieldid) {
        fieldMapper.delete_field(fieldid);
    }

    @RequestMapping("get_field_name")
    public String[] get_field_name() {
        return fieldMapper.get_fieldname();
    }

    @RequestMapping("get_video_num")
    public int[][] get_video_num() {
        String[] dates = videoMapper.get_uploadtime();
        int[][] ans = new int[dates.length][];
        for (int i = 0; i < dates.length; ++i) {
            ans[i] = videoMapper.get_video_num_by_year(dates[i]);
        }
        return ans;
    }
    @RequestMapping("get_cur_video_num")
    public int[][] get_cur_video_num() {
        String[] dates = videoMapper.get_uploadtime();
        int[][] ans = new int[dates.length][];
        for (int i = 0; i < dates.length; ++i) {
            ans[i] = videoMapper.get_video_num_by_cur_time(dates[i]);
        }
        return ans;
    }

    @RequestMapping("get_video_like_comment_num_by_fieldname")
    public int[][] get_video_like_comment_num_by_fieldname(String fieldname) {
        int[] video_id = fieldMapper.get_videoid_by_fieldname(fieldname);
        int[][] ans = new int[video_id.length][];
        for (int i = 0; i  < video_id.length; ++i) {
            int [] lc = new int[2];
            lc[0] = fieldMapper.get_video_like_num_by_videoid(video_id[i]);
            lc[1] = fieldMapper.get_video_commnet_num_by_videoid(video_id[i]);
            ans[i] = lc;
        }
        return ans;
    }

    @RequestMapping("get_video_like_comment__mean_num_by_fieldname")
    public int get_video_like_comment__mean_num_by_fieldname(String fieldname) {
        int[] video_id = fieldMapper.get_videoid_by_fieldname(fieldname);
        int ans = 0;
        for (int i = 0; i  < video_id.length; ++i) {
            ans += fieldMapper.get_video_like_num_by_videoid(video_id[i]);
        }
        ans/=video_id.length;
        return ans;
    }

}
