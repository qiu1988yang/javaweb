package com.qy.demo.demo.bean;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor  //注解在类上；为类提供一个全参的构造方法
@NoArgsConstructor  //注解在类上；为类提供一个无参的构造方法
public class User {
    String Id;
    String username;
    String password;
}
