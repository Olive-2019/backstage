package com.backstage.dao;

import com.frontstage.pojo.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VideoMapper {
    /**
     * @ Description: 通过videoid查找video
    */
    @Select("select * from video where videoid = #{videoid}")
    Video selectByPrimaryKey(Integer videoid);

    /**
     * @ Description: 找到所有的video
    */
    @Select("select * from video")
    Video[] selectAllVideo();

    /**
     * @ Description: 找到所有的区域（这个不应该在这里）
    */
    @Select("select * from field")
    Field[] selectAllField();

    /**
     * @ Description:获取点赞数前6的视频（可以通过最后的参数修改个数），未来可能结合评论数
    */
    @Select("select * from( select  video.* from video, (select nvl(count(*), 0) likenum, likeid from user_like where liketype = 0 group by likeid) Likee where video.videoid = likee.likeid order by likenum desc)where rownum<=5")
    Video[] select_hot_videos();

    /**
     * @ Description: 获取下一个videoid，用于分配videoid
    */
    @Select("select nvl(max(videoid), 0) + 1 from video")
    int get_next_videoid();

    /**
     * @ Description: 向video表中插入一条记录
    */
    @Insert("insert into video values(#{videoid}, #{description}, #{title}, #{videopath}, #{fieldid}, #{uploadtime}, #{uploader}, #{image})")
    void insert_video(Video record);

    /**
     * @ Description:通过username查找视频
    */
    @Select("select * from video where uploader = #{username}")
    Video[] get_videos_by_username(String username);

    /**
     * @ Description:通过视频标题查找视频
     */
    @Select("select * from video where title = #{title}")
    Video[] get_videos_by_title(String title);

    /**
     * @ Description:通过用户昵称查找视频
     */
    @Select("select video.*  from video, userinfo where video.uploader = userinfo.username and nickname = #{nickname}")
    Video[] get_videos_by_nickname(String nickname);

    /**
     * @ Description:根据videoid删除记录
    */

    @Delete("delete from video where videoid = #{videoid}")
    void delete_video_by_videoid(int videoid);

    @Select("select * from video where instr(title,#{request})>0")
    Video[] get_videos_by_search(String request);

    @Select("select * from video where fieldid=#{fieldID}")
    Video[] get_videos_by_field(int fieldID);

}