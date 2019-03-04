package com.na.springboot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务2
 *
 * @author fengna
 * @date 2019/3/4
 */
@Component
public class SchedulerTaskTwo {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        System.out.println("现在时间： " + DATE_FORMAT.format(new Date()));
    }
}
