package com.qy.demo.demo.one.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qy.demo.demo.one.entity.Order;
import com.qy.demo.demo.one.entity.Student;
import com.qy.demo.demo.one.entity.TbItemOne;
import com.qy.demo.demo.one.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.mapping.FetchType;

import javax.validation.constraints.AssertFalse;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

   // Student selectPersonById(Integer id);

    Student selectPersonById2(Integer id);

    Student selectPersonById3(Integer id);


    Student selectPersonById4(Integer id);


    //Student queryStudentClass();

    List<User> queryUserOrder();

    //User queryUserOrder2();

   // User queryUserOrder3();

    List<Order>  queryOrderUserResultMap();

    @Select("select * from Student")
    @Results(id="stuMap22",value={
            @Result(column="Id", property="id", id=true),
            @Result(column="Name", property="name")
    })
    List<Student> selectStudents22();

    @ResultMap(value = "stuMap22")
    @Select("select * from Student where 1=1 and " + "${ew.sqlSegment}")
    List<Student> selectStudents2(@Param("ew") QueryWrapper<Student> wrapper);


    @Override
    List<Student> selectBatchIds(@Param("idList") Collection<? extends Serializable> idList);




    @Results(id="stuMap",value = {
            @Result(property = "id",column = "Id"),
            @Result(property = "name",column = "SName"),
            @Result(property = "age",column = "Age"),
            @Result(property = "classId",column = "ClassID"),
            @Result(property = "studentClass",column = "ClassID",
                    one = @One(select = "com.qy.demo.demo.one.mapper.StudentClassMapper.selectCardById")
            )
    })

    /*ofType="com.qy.demo.demo.one.entity.StudentClass"
                    javaType="com.qy.demo.demo.one.entity.StudentClass"*/

    @Select("SELECT * FROM STUDENT WHERE ID=#{id}")
    @ResultMap(value = "stuMap")
    Student findStudentById12(Integer id);


   /* @Select("select * from Student where 1=1 and " + "${ew.sqlSegment}")
    @ResultMap(value = "stuMap")
    List<Student> selectStudents13(@Param("ew") QueryWrapper<Student> wrapper);*/








}