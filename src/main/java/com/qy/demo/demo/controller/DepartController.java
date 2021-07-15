package com.qy.demo.demo.controller;

import com.qy.demo.demo.bean.Depart;
import com.qy.demo.demo.service.DepartService;
import com.qy.demo.demo.service.Impl.DepartServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/depart")
public class DepartController {

    @Resource
    private DepartService departService = new DepartServiceImpl();

    @GetMapping(value = "/selectAll")
    public List<Depart> selectAll() {
        List<Depart> list = departService.selectAll();
        return list;
    }

}
