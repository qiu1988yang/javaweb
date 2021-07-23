package com.qy.demo.demo.one.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qy.demo.demo.one.entity.Student;
import com.qy.demo.demo.one.entity.TbItemOne;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    @Select("SELECT * FROM Student ")
    @Results(id = "stuMap", value = {
            @Result(property = "id", column = "Id",  id = true),
            @Result(property = "name", column = "SName"),
            @Result(property = "age", column = "Age"),
            @Result(property = "classId", column = "ClassID"),
            @Result(property = "studentClass", column = "StudentClass", one = @One(select = "com.qy.demo.demo.one.mapper.StudentClassMapper.selectById",fetchType = FetchType.EAGER))
    })
    Student findStudentById(int id);

    @Select("select * from Student where 1=1 and " +
            "${ew.sqlSegment}")
    @ResultMap(value = "stuMap")
    List<Student> selectStudents(@Param("ew") QueryWrapper<Student> wrapper);
    @Select("SELECT * FROM student s LEFT JOIN `stuclass` c ON s.ClassId=c.class_id")
    List<Student> selectStudentssss();

    @Select("select * from tb_item_one where id = #{id} limit 1")
    TbItemOne getByProdId(@Param("id") Integer prodId);

    @Delete("DELETE FROM tb_item_one WHERE id = #{id}")
    void delRelationByProdId(@Param("id") Integer prodId);


    Student getByBizUserId2(@Param("bizUserId") Integer bizUserId);


    String getUserIdByUnionId2(@Param("bizUserId") Integer bizUserId);

    Student selectPersonById(Integer id);

    Student selectPersonById2(Integer id);

    Student selectPersonById3(Integer id);




}