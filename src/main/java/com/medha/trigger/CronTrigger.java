package com.medha.trigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

import com.medha.job.HelloJob;
import com.medha.listener.HelloJobListener;

public class CronTrigger {

	
	public static void main(String[] args) {
		
		JobKey jobKey=new JobKey("HelloJob","HelloGroup");
		JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).withIdentity(jobKey).build();
		Trigger trigger=TriggerBuilder.newTrigger().withIdentity("triggerHelloJob","HelloGroup").withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
		
		
		try
		{
			Scheduler scheduler=new StdSchedulerFactory().getScheduler();
			scheduler.getListenerManager().addJobListener(new HelloJobListener(), KeyMatcher.keyEquals(jobKey)
		    	);
			
			scheduler.start();
			scheduler.scheduleJob(jobDetail,trigger);
		}catch(Exception ex)
		{
			
		}
	}
}
