package edu.problems.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafetyExample {

    private static Integer counter = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
//            System.out.println("Using synchronized");
//            for (int i = 0; i < 10; i++) {
//                executorService.submit(()->{
//                    synchronized(executorService){
//                        System.out.print(++counter+" ");
//                    }
//                });
//            }

            System.out.println("Using lock");
            Lock lock = new ReentrantLock();

            for (int i = 0; i < 10; i++) {
                executorService.submit(()->{
                    try{
                        lock.lock();
                        System.out.print(++counter+" ");
                    }finally {
                        lock.unlock();
                    }
                });
            }
        }finally {
            if(executorService != null) executorService.shutdown();
        }
    }
}
