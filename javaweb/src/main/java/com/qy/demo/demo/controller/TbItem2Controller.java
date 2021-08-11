package com.qy.demo.demo.controller;


import com.qy.demo.demo.exception.BizException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-07-15
 */

@RestController
@Validated
public class TbItem2Controller {


    @GetMapping("/getUser")
    public String getUserStr(@NotNull(message = "name 不能为空") String name, @Max(value = 99, message = "不能大于99岁") Integer age) {
        return "name: " + name + " ,age:" + age;
    }

    @GetMapping("/getUser2")
    public void getUserStr2() {

    }


    public static void main(String args[]) throws IOException {


    }


    @GetMapping("/getUser3")
    public  ResponseEntity findAll() {
       // return ResponseEntity.ok("111");
      //  Document doc = Jsoup.parse("");
        throw new BizException("未找到商户级别对应的信息");
      // String htmlPage = Jsoup.connect("http://www.k3.cn/p/oomobdbpmoo.html?show=3&type=image&source_id=134626&source_type=ad").get().toString();
     //   return ResponseEntity.status(HttpStatus.CREATED).body(2222);


        //add()和remove()方法在失败的时候会抛出异常(不推荐)
      /*  Queue<String> queue = new LinkedList<>();
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("poll="+queue.poll()); //返回第一个元素，并在队列中删除
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("element="+queue.element()); //返回第一个元素
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("peek="+queue.peek()); //返回第一个元素
        for(String q : queue){
            System.out.println(q);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(2222);*/
    }



}



