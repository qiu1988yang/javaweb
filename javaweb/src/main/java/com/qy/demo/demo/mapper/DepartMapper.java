package com.qy.demo.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qy.demo.demo.bean.Depart;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
public interface DepartMapper extends BaseMapper<Depart> {

    @Select({"select * from departments"})
    List<Depart> selectAll();
}
