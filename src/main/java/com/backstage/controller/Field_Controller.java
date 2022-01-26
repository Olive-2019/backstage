package com.backstage.controller;

import com.backstage.dao.FieldMapper;
import com.backstage.pojo.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Field")
@CrossOrigin("http://localhost:63342")
public class Field_Controller {

    @Autowired
    private FieldMapper fieldMapper;

    @RequestMapping("get_all_fields")
    public Field[] get_all_fields() {

        return fieldMapper.get_all_fields();
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
