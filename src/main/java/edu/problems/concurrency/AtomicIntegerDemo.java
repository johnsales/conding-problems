package edu.problems.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    private static AtomicInteger atomicCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(AtomicIntegerDemo::increment);
        Thread t2 = new Thread(AtomicIntegerDemo::increment);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Counter Value: " + atomicCounter.get());
    }

    private static void increment() {
        for (int i = 0; i < 10000; i++) {
            atomicCounter.incrementAndGet();
        }
    }
}

