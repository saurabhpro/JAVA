package main;

import job.JobA;
import job.JobB;
import job.SimpleJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

public class QuartzExample {

    public static void main(String[] args) throws InterruptedException {

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {

            Scheduler scheduler = schedulerFactory.getScheduler();

            JobDetail job = JobBuilder.newJob(SimpleJob.class)
                    .withIdentity("myJob", "group1")
                    .usingJobData("jobSays", "Hello World!")
                    .usingJobData("myFloatValue", 3.141f)
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("myTrigger", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(40).repeatForever())
                    .build();

            

            JobDetail jobA = JobBuilder.newJob(JobA.class)
                    .withIdentity("jobA", "group2")
                    .build();

            JobDetail jobB = JobBuilder.newJob(JobB.class)
                    .withIdentity("jobB", "group2")
                    .build();

            Trigger triggerA = TriggerBuilder.newTrigger()
                    .withIdentity("triggerA", "group2")
                    .startNow()
                    .withPriority(15)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(40).repeatForever())
                    .build();

            Trigger triggerB = TriggerBuilder.newTrigger()
                    .withIdentity("triggerB", "group2")
                    .startNow()
                    .withPriority(10)
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20).repeatForever())
                    .build();

            scheduler.scheduleJob(job, trigger);
            scheduler.scheduleJob(jobA, triggerA);
            scheduler.scheduleJob(jobB, triggerB);

            scheduler.start();

            TimeUnit.SECONDS.sleep(60);

            scheduler.shutdown();

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}