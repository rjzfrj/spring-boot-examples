package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

//@Configuration
public class MyConfig {
//    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(ApplicationContext applicationContext) {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
//        jobDetailFactoryBean.setJobClass(MyJob.class);
//        jobDetailFactoryBean.setName("name");
//        jobDetailFactoryBean.setGroup("group");
        jobDetailFactoryBean.setDurability(true);
        jobDetailFactoryBean.setApplicationContext(applicationContext); // 设置
        return jobDetailFactoryBean;
    }
}