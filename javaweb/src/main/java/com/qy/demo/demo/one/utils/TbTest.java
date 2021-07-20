package com.qy.demo.demo.one.utils;

import lombok.Data;

@Data
public class TbTest<T> {
    private Integer code;
    private String msg;
    private T data;

}
