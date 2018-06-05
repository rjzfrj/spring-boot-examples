package com.example.demo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>2007 All Rights Reserved.  版权所有</p>
 * <p>Company: com.allscore</p>
 * @author lzf
 * @version 1.0
 * @Date 2018年6月2日 上午11:55:33
 */
public class Task implements Runnable
{


    private String orderSn;

    public Task(String orderSn){
        this.orderSn=orderSn;
    }
    @Override
    public void run() {
        System.out.println("---------------------执行"+orderSn);
    }
}