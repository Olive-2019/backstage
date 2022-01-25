package com.backstage.dao;


import com.backstage.pojo.Field;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FieldMapper {

    int deleteByPrimaryKey(Integer fieldid);

    int insert(Field record);

    int insertSelective(Field record);

    @Select("select * from field where fieldid = #{fieldid}")
    Field selectByPrimaryKey(Integer fieldid);

    @Select("select fieldname from field where fieldid = #{fieldid}")
    String get_fieldname_by_fieldid(int fieldid);

    int updateByPrimaryKeySelective(Field record);

    int updateByPrimaryKey(Field record);
    @Select("select * from field")
    Field[] get_all_fields();
}