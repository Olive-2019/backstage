package com.backstage.dao;


import com.backstage.pojo.Field;
import com.backstage.pojo.Video;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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
    @Select("select IFNULL(max(videoid), 0) + 1 from video")
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

    @Select("select IFNULL(count(*), 0) from video")
    int get_video_num();

    @Select("select * from video")
    Video[] get_all_videos();
    @Select("select count(*) from (select distinct uploader from video) as tmp")
    int get_up_num();

    @Select("select distinct videoid from video")
    Integer[] get_all_video_id();

    @Select("select left(uploadtime, 7), ifnull(count(*), 0) from video group by left(uploadtime, 7)")
    List<List<Map<String, String>>> get_video_uploadtime_month();
    @Select("select max(left(uploadtime, 7)) from video")
    String get_max_uploadtime();

    @Select("select min(left(uploadtime, 7)) from video")
    String get_min_uploadtime();
    @Select("select distinct left(uploadtime, 7) as ym from video order by ym asc;")
    String[] get_uploadtime();

    @Select("select cnt from (select ifnull(count(*), 0) as cnt, left(uploadtime, 7) as ym from video group by left(uploadtime, 7)) as tmp where tmp.ym = #{uploadym}")
    int get_count(String uploadym);

    @Select("select title from video where fieldid = #{field_id}")
    String[] get_video_title_by_field_id(int field_id);
}