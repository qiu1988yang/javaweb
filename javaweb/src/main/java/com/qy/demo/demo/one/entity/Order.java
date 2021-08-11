package com.qy.demo.demo.one.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "order")
public class Order {


    private Integer id;
    private Integer userId;
    private String number;
    private Date createtime;
    private String note;

    private com.qy.demo.demo.one.entity.User user;


}
