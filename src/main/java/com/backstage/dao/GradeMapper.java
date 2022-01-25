package com.backstage.dao;

import com.frontstage.pojo.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GradeMapper {
    @Select("select * from grade where #{point} between lowpoint and highpoint")
    Grade get_grade(int point);
}