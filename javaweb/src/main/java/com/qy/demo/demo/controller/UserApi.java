package com.qy.demo.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.qy.demo.demo.bean.User;
import com.qy.demo.demo.jwt.BaseUserInfo;
import com.qy.demo.demo.jwt.TokenService;
import com.qy.demo.demo.jwt.UserLoginToken;
import com.qy.demo.demo.one.utils.Result;
import com.qy.demo.demo.one.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class UserApi {
    /*  @Autowired
      UserService userService;*/
    @Resource
    TokenService tokenService;
    @Autowired
    RedisTemplate redisTemplate;


    //登录
    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        User userForBase = new User();
        userForBase.setUsername("111");
        userForBase.setPassword("111");
        userForBase.setId("1111");
        System.out.println(1111111);
        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
            } else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    @GetMapping("/getMessage")
    public String getMessage() {


        String allKey = "allUser";
       // List<User> lists = (List<User>) redisTemplate.boundValueOps(allKey).get();
/*        List<User> lists =  new ArrayList<>();
        User u = new User();
        u.setId("222");
        lists.add(u);
        if(lists != null){
            System.out.println("inner redis success!!");
        }*/
        redisTemplate.boundValueOps(allKey).set("222");


        return BaseUserInfo.get("id");
    }

    @GetMapping("/getMessage2")
    public Result getMessage2() {
        String allKey = "allUser";
        //List<User> lists = (List<User>) redisTemplate.boundValueOps(allKey).get();
        return ResultUtil.success(redisTemplate.boundValueOps(allKey).get());
    }
}