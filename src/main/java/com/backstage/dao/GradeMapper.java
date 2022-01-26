package com.backstage.dao;


import com.backstage.pojo.Grade;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GradeMapper {
    @Select("select * from grade where #{point} between lowpoint and highpoint")
    Grade get_grade(int point);

    @Select("select * from grade")
    Grade[] get_all_grades();

    @Delete("delete from grade where grade = #{grade}")
    void delete_grade(int grade);

    @Insert("insert into grade values(#{grade}, #{lowpoint}, #{highpoint})")
    void insert_grade(Grade grade);

    @Select("select * from grade where grade = #{grade}")
    Grade get_grade_by_grade(int grade);
}