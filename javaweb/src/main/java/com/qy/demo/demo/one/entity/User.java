package com.qy.demo.demo.one.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@TableName(value = "user")
public class User {
    private Integer id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;

    private List<Order> orders;

    private Order orders2;


}
