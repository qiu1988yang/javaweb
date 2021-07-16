package com.qy.demo.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qy.demo.demo.entity.Bserrr;
import com.qy.demo.demo.entity.TbItem;

import com.qy.demo.demo.exception.ResponseResult;
import com.qy.demo.demo.exception.ResultEnum;
import com.qy.demo.demo.mapper.TbItemMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-07-15
 */

@RestController
@RequestMapping("/test/item")
public class TbItemController {


    @Resource
    private TbItemMapper tbItemMapper;

    @PostMapping(value = "/add")
    public void selectAll() {
        TbItem tbItem = new TbItem();
        tbItem.setCreated(LocalDateTime.now());
        int insert = tbItemMapper.insert(tbItem);
    }

    @GetMapping(value = "/find")
    public List<TbItem> selectFind() {
        QueryWrapper<TbItem> ew = new QueryWrapper<>();
        ew.like("title", "ww");
        List<TbItem> users = tbItemMapper.selectList(ew);
        users.forEach(System.out::println);
        return users;
    }

    @GetMapping(value = "/update")
    public TbItem update() {
        QueryWrapper<TbItem> ew = new QueryWrapper<>();
        ew.like("id", "1474391966");
        TbItem tbItem = tbItemMapper.selectOne(ew);
        System.out.println(tbItem);
        tbItem.setTitle("大王叫我来巡山！！！");
        int i = tbItemMapper.updateById(tbItem);
        ResponseEntity.ok("q11111");
        return tbItem;
    }


    @GetMapping(value = "/findTest")
    public void find(@RequestParam String myName) {


        System.out.println(myName);
        System.out.println(22222);


    }


    @GetMapping(value = "/findTest2")
    public TbItem find2(@RequestBody @Valid TbItem tbItem
    ) {

       // getMessage();
        System.out.println(22222);

        return tbItem;

    }
    @GetMapping(value = "/findTest22")
    //    public Map<Object, Object> vali(@Valid  @RequestBody  Bserrr bserrr){
    public String find223(@RequestBody @Valid TbItem tbItem , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }
     /*
       Map<Object, Object> res = new HashMap<>();
        if (bindingResult.hasErrors()) {
            res.put("status", 400);
            res.put("msg", bindingResult.getFieldError().getDefaultMessage());
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            //return res;
        } else {
            res.put("status", 200);
            res.put("msg", "ok");
            res.put("data", bindingResult.hasErrors());
          //  return res;
        }*/
        return "222";
    }


    @PostMapping(value = "/findTest3")
    public ResponseResult vali(@Valid @RequestBody Bserrr bserrr){
        System.out.println(bserrr.getName());
        return new ResponseResult(ResultEnum.SUCCESS);
    }



}
