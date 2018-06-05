package com.example.demo.poolconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


/**
 * <p>Title: </p>
 * <p>Description:  线程池配置</p>
 * <p>2007 All Rights Reserved.  版权所有</p>
 * <p>Company: com.allscore</p>
 * @author lzf
 * @version 1.0
 * @Date 2018年6月2日 上午11:55:33
 */
@Configuration
@EnableAsync
public class ExecutorConfig {
    private static int CORE_POOL_SIZE = 5;
    private static int MAX_POOL_SIZE = 20;
    @Bean(name="taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();

        //线程池维护线程的最少数量
        poolTaskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        //线程池维护线程的最大数量
        poolTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        //线程池所使用的缓冲队列
        poolTaskExecutor.setQueueCapacity(200);
        //线程池维护线程所允许的空闲时间
        poolTaskExecutor.setKeepAliveSeconds(30000);
        poolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        return poolTaskExecutor;
    }
}
