package com.example.client;


import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Model：
 * Description：
 * Author: 赖允翔
 * created：2020/1/3 11:47
 */
@RestController
//@RateLimiter(name = "limiterA")
public class testcontroller {

    @Autowired
    CircuitBreakerRegistry circuitBreakerRegistry;
    @Autowired
    private testService t;

    @RequestMapping("/hello")
    @Retry(name = "retryA")
    public String a1(@RequestParam(value = "id", required = false) String id) throws Exception {
        return t.a(id);
    }

    @RequestMapping("/hello1")
    @RateLimiter(name = "backendA")
    public String a2(@RequestParam(value = "id", required = false) String id) throws Exception {
        String a = null;
        for (int i = 0; i < 4; i++) {
            a = t.a1(id);

        }
        return a;
    }

    @RequestMapping("/hello2")
    @Retry(name = "retryA")
    public String a3(@RequestParam(value = "id", required = false) String id) throws Exception {
//        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
//                .failureRateThreshold(50)
//                .waitDurationInOpenState(Duration.ofMillis(1000))
//                .ringBufferSizeInHalfOpenState(5)
//                .ringBufferSizeInClosedState(3)
//                .build();
//        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("breakA", circuitBreakerConfig);
//        Try<String> supplier = Try.ofSupplier(CircuitBreaker
//                .decorateSupplier(circuitBreaker,() -> t.a1(id)))
//                .recover(Exception.class, "有异常，访问失败!");
//        return supplier.get();
        String a = null;
        for (int i = 0; i < 4; i++) {
            a = t.a1(id);

        }
        return a;
    }
}
