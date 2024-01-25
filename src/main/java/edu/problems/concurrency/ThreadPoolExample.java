package edu.problems.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    private static Random random = new Random();

    public static void main(String[] args) {
        Runnable task = () -> {
            int sleepTime = random.nextInt(10);// 0 - 9
            System.out.println("Start of task with id "+Thread.currentThread().getId() + " (Task will take "+sleepTime+" seconds)");
            try {
                Thread.sleep(sleepTime * 1000);
            } catch (InterruptedException e) {}

            System.out.println("End of task with id "+Thread.currentThread().getId());
        };

        ExecutorService executorService = Executors.newFixedThreadPool(4);//Cached, or Scheduled options too
        try {
            executorService.submit(task);
            executorService.submit(task);
            executorService.submit(task);
            executorService.submit(task);
        }finally {
            if (executorService != null)
                executorService.shutdown();
        }
    }
}
