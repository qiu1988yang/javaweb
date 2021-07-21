package com.qy.demo.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.qy.demo.demo.bean.User;
import com.qy.demo.demo.jwt.BaseUserInfo;
import com.qy.demo.demo.jwt.TokenService;
import com.qy.demo.demo.jwt.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("api")
public class UserApi {
    /*  @Autowired
      UserService userService;*/
    @Resource
    TokenService tokenService;

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

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return BaseUserInfo.get("id");
    }
}