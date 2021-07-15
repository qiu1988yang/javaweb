package com.qy.demo.demo.mapper;

import com.qy.demo.demo.bean.Depart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartMapper {

    @Select({"select * from departments"})
    List<Depart> selectAll();
}
