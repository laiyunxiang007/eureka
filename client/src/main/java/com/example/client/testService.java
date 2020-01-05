package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Model：
 * Description：
 * Author: 赖允翔
 * created：2020/1/3 11:48
 */
@FeignClient(name = "producer")
public interface testService {

    @RequestMapping("/hello")
    String a(@RequestParam(value = "id", required = false) String id);

    @RequestMapping("/hello1")
    String a1(@RequestParam(value = "id", required = false) String id);
}
