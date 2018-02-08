package com.medha.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class HelloJobListener implements JobListener{

	private String LISTENER_NAME="*HELLO LISTENER*";
	
			
			
	public String getName() {
		// TODO Auto-generated method stub
		return LISTENER_NAME;
	}

	public void jobExecutionVetoed(JobExecutionContext arg0) {
		// TODO Auto-generated method stub
		
		System.out.println(" Job Execution Vetoed");
		
	}

	public void jobToBeExecuted(JobExecutionContext jobExecContext) {
		// TODO Auto-generated method stub
		
		System.out.println("job to be executed");
		String jobName=jobExecContext.getJobDetail().getKey().toString();
		System.out.println("JOb: "+jobName+" is going to start");
		
	}

	public void jobWasExecuted(JobExecutionContext jobExecContext,
			JobExecutionException jobException) {
		// TODO Auto-generated method stub
		String jobName=jobExecContext.getJobDetail().getKey().toString();
		System.out.println("Job was executed "+jobName);
		System.out.println(jobName+"  is finished!!");
		if(!jobException.getMessage().equals(""))
		{
			System.out.println("Exception thrown by: " + jobName
				+ " Exception: " + jobException.getMessage());
			
		}
		
	}

}
