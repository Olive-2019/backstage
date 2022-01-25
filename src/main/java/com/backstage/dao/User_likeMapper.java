package com.backstage.dao;

import com.frontstage.pojo.User_like;
import com.frontstage.pojo.Userinfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface User_likeMapper {

    @Insert("insert into user_like values(#{username}, #{likeid}, #{liketype})")
    int insert(User_like record);

    int insertSelective(User_like record);

    @Select("select count(*) from user_like where liketype = #{liketype} and likeid = #{likeid}")
    int select_like_count(int liketype, int likeid);

    @Delete("delete from user_like where username = #{username} and likeid = #{likeid} and liketype = #{likeid}")
    void delete_like(User_like user_like);

    @Select("select count(*) from user_like where username = #{username} and likeid = #{likeid} and liketype = #{liketype}")
    int select_like_count_by_object(User_like user_like);

    @Select("select userinfo.*  from user_like , userinfo where liketype = #{liketype} and likeid = #{likeid} and user_like.username = userinfo.username")
    Userinfo[] get_like_this_object_user(int liketype, int likeid);
}