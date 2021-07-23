package com.qy.demo.demo.one.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qy.demo.demo.one.entity.Student;
import com.qy.demo.demo.one.mapper.StudentClassMapper;
import com.qy.demo.demo.one.mapper.StudentMapper;
import com.qy.demo.demo.one.service.ITbItemOneService;
import com.qy.demo.demo.one.utils.Result;
import com.qy.demo.demo.one.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-07-17
 */
@RestController
@RequestMapping("/one/one")
public class OneController {

    @Autowired
    private ITbItemOneService itemOneService;

    @Resource
    private StudentMapper studentMapper;
    @Resource
    private StudentClassMapper studentClassMapper;



    @GetMapping(value = "/add")
    public Result add() {
      //  studentMapper.selectPersonById(1)  一对一案例


        return ResultUtil.success(studentMapper.selectPersonById3(1)  );
    }
}


