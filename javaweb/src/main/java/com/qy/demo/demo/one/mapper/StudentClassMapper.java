package com.qy.demo.demo.one.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qy.demo.demo.one.entity.StudentClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentClassMapper extends BaseMapper<StudentClass> {

    StudentClass selectCardById(Integer cid);

    List<StudentClass> selectCardByAll(Integer id);

}