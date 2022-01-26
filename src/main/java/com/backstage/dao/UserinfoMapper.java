package com.backstage.dao;

import com.backstage.pojo.User_comment;
import com.backstage.pojo.Userinfo;
import com.backstage.pojo.Video;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserinfoMapper {


    /**
     * @ Description:插入用户信息
    */

    @Insert("insert into userinfo values(#{username}, #{password}, #{nickname}, #{point}, #{admin})")
    int insert(Userinfo user);

    /**
     * @ Description: 通过username查询用户
    */
    @Select("select * from userinfo where username = #{username}")
    Userinfo selectByPrimaryKey(String username);

    /**
     * @ Description: 根据用户名更新别名
    */
    @Update("update userinfo set nickname = #{nickname} where username=#{username}")
    void update_nickname(String nickname, String username);

    /**
     * @ Description: 根据用户名更新密码
     */
    @Update("update userinfo set password = #{password} where username=#{username}")
    void update_password(String password, String username);

    /**
     * @ Description:获取粉丝信息
    */
    @Select("select follower.* from userinfo cur, follow, userinfo follower where cur.username = #{username} and cur.username = follow.usernamefollowed and follow.usernamefollower = follower.username")
    Userinfo[] get_follower(String username);

    /**
     * @ Description:获取粉丝数量
    */
    @Select("select count(*) from userinfo cur, follow, userinfo follower where cur.username = #{username} and cur.username = follow.usernamefollowed and follow.usernamefollower = follower.username")
    int get_follower_num(String username);

    /**
     * @ Description:获取关注对象信息
    */
    @Select("select followed.* from userinfo cur, follow, userinfo followed where cur.username = #{username} and cur.username = follow.usernamefollower and follow.usernamefollowed = followed.username")
    Userinfo[] get_followed(String username);

    /**
     * @ Description:获取关注对象数量
    */
    @Select("select count(*) from userinfo cur, follow, userinfo followed where cur.username = #{username} and cur.username = follow.usernamefollower and follow.usernamefollowed = followed.username")
    int get_followed_num(String username);

    /**
     * @ Description:获得用户分数
    */
    @Select("select point from userinfo where username = #{username}")
    int get_point(String username);

    /**
     * @ Description:获得用户等级
    */
    @Select("select grade.grade from userinfo, grade where username = #{username} and point between lowpoint and highpoint")
    int get_grade(String username);

    /**
     * @ Description:获取用户点赞过的视频
    */
    @Select("select video.* from user_like, video where username = #{username} and liketype = #{type} and video.videoid = user_like.likeid")
    Video[] get_like_video(String username, int type);

    /**
     * @ Description:获取用户点赞过的评论
    */
    @Select("select user_comment.* from user_like, user_comment where user_like.username = #{username} and liketype = #{type} and user_comment.commentid = user_like.likeid")
    User_comment[] get_like_comment(String username, int type);

    /**
     * @ Description:获取用户评论过的视频
     */
    @Select("select v.* from user_comment uc, video v where uc.username = #{username} and commenttype = #{type} and uc.commenttoid = v.videoid")
    Video[] get_comment_video(String username, int type);

    @Select("select uc.* from user_comment uc, video v where uc.username = #{username} and commenttype = #{type} and uc.commenttoid = v.videoid")
    User_comment[] get_comment_video_comment(String username, int type);
    /**
     * @ Description:获取用户评论过的评论
     */
    @Select("select commentee.* from user_comment commentor, user_comment commentee where commentor.username = #{username} and commentor.commenttype = #{type} and commentor.commenttoid = commentee.commentid")
    User_comment[] get_comment_comment(String username, int type);

    /**
     * @ Description: 获取用户评论过的评论 （当前用户发的）
    */
    @Select("select commentor.* from user_comment commentor, user_comment commentee where commentor.username = #{username} and commentor.commenttype = #{type} and commentor.commenttoid = commentee.commentid")
    User_comment[] get_comment_comment_comment(String username, int type);

    @Select("select video.* from userinfo, video where username = #{username} and username = video.uploader")
    Video[] get_upload_video(String username);


    @Select("select nvl(count(*), 0) from userinfo")
    int get_user_num();

    @Select("select * from userinfo")
    Userinfo[] get_all_user();

    @Delete("delete from userinfo where username = #{username}")
    void delete_user(String username);
}