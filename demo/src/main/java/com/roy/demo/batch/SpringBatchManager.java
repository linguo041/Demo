package com.roy.demo.batch;

import java.net.URL;
import java.util.Arrays;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.converter.DefaultJobParametersConverter;
import org.springframework.batch.core.converter.JobParametersConverter;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.ExitCodeMapper;
import org.springframework.batch.core.launch.support.SimpleJvmExitCodeMapper;
import org.springframework.util.StringUtils;

public class SpringBatchManager {

	private SpringBatchContext ctx;
	private String [] args;
	
	private SpringBatchManager (String args[]) {
		this.args = args;
		this.ctx = new SpringBatchContext();
		this.ctx.init(args[0], SpringBatchConfiguration.class);
	}

	private void validateArgs (String args[]) throws IllegalArgumentException{
		if (args == null || args.length <= 0) {
			throw new IllegalArgumentException ("No argument input.");
		}
	}

	private JobExecution runJob () throws Exception{
		JobParameters jobParameters = getJobParameters(args);
		JobLauncher jobLauncher = ctx.getBean(JobLauncher.class);
		Job job = ctx.getBean(Job.class);

		return jobLauncher.run(job, jobParameters);
	}

	private JobParameters getJobParameters(String args[]) {
		JobParametersConverter jobParametersConverter = new DefaultJobParametersConverter();
		
		String [] arguments = Arrays.copyOfRange(args, 1, args.length);
		JobParameters jobParameters = jobParametersConverter
				.getJobParameters(StringUtils.splitArrayElementsIntoProperties(arguments, "="));

		return jobParameters;
	}

	private static void process (String args[]) {
		ExitStatus exitStatus = ExitStatus.COMPLETED;

		try {
			SpringBatchManager manager = new SpringBatchManager(args);
			manager.validateArgs(args);
			JobExecution jobExecution = manager.runJob();
			exitStatus = jobExecution.getExitStatus();
		} catch (Exception e) {
			e.printStackTrace();
			exitStatus = ExitStatus.FAILED;
		} finally {
			exit(exitStatus);
		}
	}

	private static void exit (ExitStatus exitStatus) {
		ExitCodeMapper exitCodeMapper = new SimpleJvmExitCodeMapper();
		int status = exitCodeMapper.intValue(exitStatus.getExitCode());
		System.exit(status);
	}

	public static void main (String args[]) {
//		URL url = SpringBatchManager.class.getClassLoader().getResource(args[0]);
//		System.out.println(url);
//		process(args);
		
		Object a = getObj();
		double b = Double.parseDouble(a.toString());
		System.out.println(b);
	}
	
	private static Object getObj () {
		return new Integer (10);
	}
}
