package com.example.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Model：
 * Description：
 * Author: 赖允翔
 * created：2020/1/6 15:26
 */
@RestController
public class test {
    @RequestMapping("/fallback")
    public String a(){
        return "超时。。。。。。。。。";
    }
}
