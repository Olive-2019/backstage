package com.backstage.controller;

import com.backstage.dao.FieldMapper;
import com.backstage.dao.VideoMapper;
import com.backstage.pojo.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
}
