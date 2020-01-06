package com.example.producer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Model：
 * Description：
 * Author: 赖允翔
 * created：2020/1/3 10:50
 */
@RestController
public class test {
    @RequestMapping("/hello")
    public String a(@RequestParam(value = "id", required = false) String id) throws InterruptedException {
        Thread.sleep(5500);
        System.out.println("超时了。。。。。。");
        return id;
    }

    @RequestMapping("/hello1")
    public String a2(@RequestParam(value = "id", required = false) String id) throws InterruptedException {
        Thread.sleep(5500);
        return id;
    }
}
