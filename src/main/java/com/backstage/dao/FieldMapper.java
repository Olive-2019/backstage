package com.backstage.dao;


import com.backstage.pojo.Field;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}