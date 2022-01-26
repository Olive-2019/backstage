package com.backstage.dao;


import com.backstage.pojo.History;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.Date;

@Mapper
public interface HistoryMapper {

    int insert(History record);

    int insertSelective(History record);

    @Select("select * from history where username=#{username}")
    History[] get_history(String username);

    @Select("select count(*) from history where time>=#{time1} and time<=#{time2}")
    int get_watches(LocalDate time1,LocalDate time2);

    @Select("select count(*) from history where videoid=#{videoid}")
    int get_watches_by_ID(int videoid);
    @Select("select count(*) " +
            "    from history where videoid in " +
            "        (select videoid from video where username='somebody')")
    int get_history_num_by_username(String username);

    @Select("select count(*) from history")
    int get_history_num();

    @Select("select count(*) from history where finish=1")
    int get_finish_history_num();

    @Select("select count(*) from (select distinct username from history where time>#{time})")
    int get_active_user_num(LocalDate time);

}