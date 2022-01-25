package com.backstage.dao;


import com.backstage.pojo.Barrage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BarrageMapper {

    int deleteByPrimaryKey(Integer barrageid);
    @Insert("insert into barrage values(#{barrageid},#{username},#{videoid},#{content},#{time})")
    int insert(Barrage record);

    int insertSelective(Barrage record);

    Barrage selectByPrimaryKey(Integer barrageid);

    int updateByPrimaryKeySelective(Barrage record);

    int updateByPrimaryKey(Barrage record);

    @Select("select * from barrage where videoID=#{videoID}")
    Barrage[] get_barrage_by_video(int videoID);

    @Select("select nvl(max(barrageid),0)+1 from barrage")
    int get_barrage_ID();
}