package com.neo.controller;

import com.neo.redis.config.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Autowired
	private RedisUtil redisUtil;
    @RequestMapping("/hello")
    public String index(String key) {
        redisUtil.set(key,"hello"+System.currentTimeMillis());
        String r= (String) redisUtil.get(key);
        return r;
    }
}