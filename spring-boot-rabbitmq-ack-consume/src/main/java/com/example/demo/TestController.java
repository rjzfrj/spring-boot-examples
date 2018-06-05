package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/mq")
public class TestController {

    @Autowired
    private HelloSender helloSender;

    /**
     * 单生产者-单个消费者
     */
    @RequestMapping("/test")
    public void hello() throws Exception {
        helloSender.send();
        helloSender.sendObj();
    }
}
