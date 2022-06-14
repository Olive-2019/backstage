package com.backstage.dao;


import com.backstage.pojo.Follow;
import com.backstage.pojo.Userinfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FollowMapper {

    int deleteByPrimaryKey(Follow key);

    @Select("select * from follow")
    Follow[] get_all_link();

    @Insert("insert into follow values(#{usernamefollowed}, #{usernamefollower})")
    int insert(Follow record);

    @Select("select count(*) from follow where usernamefollowed = #{usernamefollowed} and usernamefollower = #{usernamefollower}")
    int is_exist(Follow record);

    @Delete("delete from follow where usernamefollowed = #{usernamefollowed} and usernamefollower = #{usernamefollower}")
    void delete_record(Follow record);

    @Select("select userinfo.* from userinfo, follow where username = usernamefollower and usernamefollowed = #{username}")
    Userinfo[] get_follower(String username);

    @Select("select userinfo.* from userinfo, follow where username = usernamefollowed and usernamefollower = #{username}")
    Userinfo[] get_followed(String username);
}