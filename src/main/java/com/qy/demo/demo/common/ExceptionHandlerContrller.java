package com.qy.demo.demo.common;


import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerContrller {

    /**
     * 当使用了 @Validated + @RequestBody 注解但是没有在绑定的数据对象后面跟上 Errors 类型的参数声明的话，
     * Spring MVC 框架会抛出 MethodArgumentNotValidException 异常。
     * 当抛出 MethodArgumentNotValidException 异常,就会被相应的异常处理捕捉到理(有点类似于aop的意思)
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class) //指定异常类型
    @ResponseBody
    public List<ErrorMsg> exception(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        List<ErrorMsg> errorMsgs = new ArrayList<>();
        System.out.println(1111);
        allErrors.forEach(objectError -> {
            ErrorMsg errorMsg = new ErrorMsg();
            FieldError fieldError = (FieldError)objectError;
            errorMsg.setField(fieldError.getField());
            errorMsg.setObjectName(fieldError.getObjectName());
            errorMsg.setMessage(fieldError.getDefaultMessage());
            errorMsgs.add(errorMsg);
        });
        System.out.println(222);
        return errorMsgs;
    }
}
