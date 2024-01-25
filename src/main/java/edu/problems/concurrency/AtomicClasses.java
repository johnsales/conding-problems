package edu.problems.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicClasses {

    private static Integer counter = 0;
    private static AtomicInteger atomicCounter = new AtomicInteger();//AtomicInteger,AtomicLong,AtomicBoolean

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
//            System.out.println("1 - Normal counter - concurrency issue");
//            for (int i = 0; i < 10; i++) {
//                executorService.submit(()->{
//                    System.out.print(++counter+" ");
//                });
//            }
            System.out.println("\n2 - Atomic Normal counter");
            for (int i = 0; i < 10; i++) {
                executorService.submit(()->{
                    System.out.print(atomicCounter.incrementAndGet()+" ");//add synchronized for print ordering
                });
            }
        }finally {
            if(executorService != null) executorService.shutdown();
        }
    }
}
