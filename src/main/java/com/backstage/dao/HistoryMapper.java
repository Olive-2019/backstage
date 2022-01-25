package com.backstage.dao;


import com.backstage.pojo.History;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HistoryMapper {

    int insert(History record);

    int insertSelective(History record);

    @Select("select * from history where username=#{username}")
    History[] get_history(String username);
}