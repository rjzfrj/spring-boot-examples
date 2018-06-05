package com.example.demo.job;

import java.util.Date;

import com.example.demo.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  
import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;


public class NewJob implements BaseJob {
    private static Logger _log = LoggerFactory.getLogger(NewJob.class);
     
    public NewJob() {  
          
    }  
     
    public void execute(JobExecutionContext context)  
        throws JobExecutionException {  
        _log.error("New Job执行时间: " + new Date());  
    }
}  