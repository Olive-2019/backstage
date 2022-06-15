package com.backstage.dao;


import com.backstage.pojo.Field;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FieldMapper {



    @Insert("insert into field values(#{fieldid}, #{fieldname})")
    int insert(Field record);



    @Select("select * from field where fieldid = #{fieldid}")
    Field selectByPrimaryKey(Integer fieldid);

    @Select("select fieldname from field where fieldid = #{fieldid}")
    String get_fieldname_by_fieldid(int fieldid);

    @Select("select fieldname from field order by fieldname desc")
    String[] get_fieldname();

    @Select("select * from field")
    Field[] get_all_fields();

    @Delete("delete from field where fieldid = #{fieldid}")
    void delete_field(int fieldid);

    @Select("select (IFNULL(max(fieldid), 0)+1) from field")
    int get_next_id();

    @Select("select videoid from field, video where fieldname = #{fieldname} and video.fieldid = field.fieldid order by videoid asc")
    int[] get_videoid_by_fieldname(String fieldname);

    @Select("select ifnull(count(*), 0) from field, video, user_like where fieldname = #{fieldname} and video.fieldid = field.fieldid and user_like.likeid = videoid group by videoid order by videoid asc;")
    int[] get_video_like_num_by_fieldname(String fieldname);

    @Select("select ifnull(count(*), 0) from field, video, user_comment where fieldname = #{fieldname} and video.fieldid = field.fieldid and user_comment.commenttoid = videoid group by videoid order by videoid asc;")
    int[] get_video_comment_num_by_fieldname(String fieldname);

    @Select("select count(*) as li from video, user_like where videoid = #{vid} and user_like.likeid = videoid")
    int get_video_like_num_by_videoid(int vid);

    @Select("select count(*) as com from video, user_comment  where videoid = #{vid} and user_comment.commenttoid = videoid")
    int get_video_commnet_num_by_videoid(int vid);
}