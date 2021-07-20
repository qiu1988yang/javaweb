package com.qy.demo.demo.entity;

import lombok.Data;

@Data
public class SysUser {

    private String id;
    private String username;
    private String password;

    public SysUser(String username,String password){
        this.username = username;
        this.password = password;
    }
}