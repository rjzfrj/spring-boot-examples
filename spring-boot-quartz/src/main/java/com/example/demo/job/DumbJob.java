package com.example.demo.job;

import com.example.demo.task.Task;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
@Component("dumbJob")
@Lazy(false)
public class DumbJob implements BaseJob {
    private static Logger _log = LoggerFactory.getLogger(DumbJob.class);
    String jobSays;
    float myFloatValue;
    ArrayList state;

//    @Autowired
//    private  ThreadPoolTaskExecutor taskExecutor;
    public DumbJob() {
          
    }  
     
    public void execute(JobExecutionContext context)  
        throws JobExecutionException {  
        _log.error("New Job执行时间: " + new Date());
//        taskExecutor.execute(new Task("99999"));
//        TODO怎么使用spring容器中的对象
    }

    public void setJobSays(String jobSays) {
        this.jobSays = jobSays;
    }

    public void setMyFloatValue(float myFloatValue) {
        myFloatValue = myFloatValue;
    }

    public void setState(ArrayList state) {
        state = state;
    }
}  