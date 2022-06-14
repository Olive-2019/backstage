package com.backstage.controller;

import com.backstage.dao.BarrageMapper;
import com.backstage.dao.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Vector;

@RestController
@RequestMapping("Barrage")
@CrossOrigin("http://localhost:63342")
public class Barrage_Controller {
    @Autowired
    private BarrageMapper barrageMapper;
    @Autowired
    private VideoMapper videoMapper;
    @RequestMapping("get_barrage_num")
    int get_barrage_num() {
        return barrageMapper.get_barrage_num();
    }

}
