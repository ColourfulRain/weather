package com.weather.job;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author：lqq
 * @ClassName：QuartzConfigration
 * @Time：2020/3/1
 * @Describe：配置定时任务
 */
@Configuration
public class QuartzConfiguration {

    //Detail
    @Bean
    public JobDetail weatherSyncJobDetail() {
        //通过一个工作对象，并且设置工作名，组名
        return JobBuilder.newJob(WeatherQuartz.class).withIdentity("weatherQuartz","group1")
                //持久储存，并且建立
                .storeDurably().build();
    }

    //Trigger
    @Bean
    public Trigger weatherDataSyncTrigger() {

        SimpleScheduleBuilder ssl = SimpleScheduleBuilder
                .simpleSchedule().withIntervalInSeconds(1800).repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherSyncJobDetail())
                .withIdentity("weatherSyncJobDetail","group1").withSchedule(ssl).build();
    }
}
