package com.qy.demo.demo.exception;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ResponseResult<T> {
    private Integer code;
    private String msg;
    private T data;


    public ResponseResult(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMessage();
    }

    public ResponseResult(Integer code, String msg ,T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult() {

    }

    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setCode(EnumResultCode.SUCCESS.getCode());
        result.setMsg(EnumResultCode.SUCCESS.getMsg());
        result.setData(data);

        return result;
    }

    public static <T> ResponseResult<T> fail(T data) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setCode(EnumResultCode.FAIL.getCode());
        result.setMsg(EnumResultCode.FAIL.getMsg());
        result.setData(data);
        return result;
    }

    public static <T>ResponseResult<T> fail(String msg) {
        ResponseResult<T> result = new ResponseResult<T>();
        result.setCode(EnumResultCode.FAIL.getCode());
        result.setMsg(msg);
        return result;
    }

    public enum EnumResultCode{
        SUCCESS(1000,"成功"),
        FAIL(1001,"失败");

        private int code;
        private String msg;

        private EnumResultCode(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }
        public void setCode(int code) {
            this.code = code;
        }
        public String getMsg() {
            return msg;
        }
        public void setMsg(String msg) {
            this.msg = msg;
        }

    }




}
