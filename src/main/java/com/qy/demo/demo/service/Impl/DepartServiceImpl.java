package com.qy.demo.demo.service.Impl;

import com.qy.demo.demo.bean.Depart;
import com.qy.demo.demo.mapper.DepartMapper;
import com.qy.demo.demo.service.DepartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departService")


public class DepartServiceImpl implements DepartService {

    private DepartMapper departMapper;

    @Override
    public List<Depart> selectAll() {
        return departMapper.selectAll();
    }
}
