package com.backstage.dao;


import com.backstage.pojo.User_comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface User_commentMapper {

    @Select("select * from user_comment where commentid = #{commentid}")
    User_comment select_by_id(int commentid);

    @Insert("insert into user_comment values(#{username}, #{commentid}, #{content}, #{commenttype}, #{commenttoid})")
    int insert(User_comment record);

    @Select("select nvl(max(commentid),0)+1 from user_comment")
    int get_next_comment_id();

    @Select("select count(*) from user_comment where commentid = #{commentid}")
    int select_counter_by_commentid(int commentid);

    @Delete("delete from user_comment where commentid = #{commentid}")
    void delete_by_commentid(int commentid);

    @Select("select count(*) from user_comment where commenttype = #{commenttype} and commenttoid = #{commenttoid}")
    int get_comment_counter(int commenttype, int commenttoid);

    @Select("select * from user_comment where commenttype = #{commenttype} and commenttoid = #{commenttoid}")
    User_comment[] get_comments(int commenttype, int commenttoid);

    @Select("select nvl(count(*), 0) from user_comment")
    int get_comment_num();


}