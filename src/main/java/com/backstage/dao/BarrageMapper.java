package com.backstage.dao;


import com.backstage.pojo.Barrage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BarrageMapper {

    @Insert("insert into barrage values(#{barrageid},#{username},#{videoid},#{content},#{time})")
    int insert(Barrage record);


    @Select("select * from barrage where videoID=#{videoID}")
    Barrage[] get_barrage_by_video(int videoID);

    @Select("select nvl(max(barrageid),0)+1 from barrage")
    int get_barrage_ID();

    @Select("select nvl(count(*), 0) from barrage")
    int get_barrage_num();
}