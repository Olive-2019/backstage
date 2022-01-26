package com.backstage.controller;

import com.backstage.dao.GradeMapper;
import com.backstage.pojo.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Grade")
@CrossOrigin("http://localhost:63342")
public class Grade_Controller {
    @Autowired
    private GradeMapper gradeMapper;

    @RequestMapping("get_all_grades")
    public Grade[] get_all_grades() {
        return gradeMapper.get_all_grades();
    }

    @RequestMapping("delete_grade")
    public void delete_grade(int grade) {
        gradeMapper.delete_grade(grade);
    }

    @RequestMapping("insert_grade")
    public boolean insert_grade(Grade grade) {
        Grade old_grade = gradeMapper.get_grade_by_grade(grade.getGrade());
        if (old_grade != null) return false;
        gradeMapper.insert_grade(grade);
        return true;
    }


}
