package com.github.xuchen93.scheduling;

import cn.hutool.Hutool;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author xuchen.wang
 * @date 2023/8/16
 */
@Component
public class SchedulingTest {

    @Scheduled(cron = "0 20 3 1 * *")
    public void test1(){

    }

    public static void main(String[] args) {
        String cron = "0 20 3 1 * *";
        CronSequenceGenerator generator = new CronSequenceGenerator(cron);
        Date next = new Date();
        while (true){
            next = generator.next(next);
            System.out.println(DateUtil.formatDateTime(next));
            ThreadUtil.sleep(1000);

        }
    }
}
