package com.roy.demo.batch.tasklet;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class HelloWorldTasklet implements Tasklet {

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		JobParameters parameters = chunkContext.getStepContext().getStepExecution().getJobParameters();
		
		System.out.println("######Hello world#######");
		System.out.println(parameters.getString("username"));
		return null;
	}

}
