package com.na.springboot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 *
 * @author fengna
 * @date 2019/3/4
 */
@Component
public class SchedulerTaskOne {

    private int count = 0;

    @Scheduled(cron = "*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task running  " + count++);
    }
}
