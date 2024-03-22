package edu.problems.concurrency;

/**
 Thread.yield(): This method is a static method of the Thread class that causes the currently executing thread to
 pause and allow other threads to execute. It's a way of telling the thread scheduler that the current thread is
 willing to yield its current use of a processor. The scheduler is free to ignore this hint. Thread.yield() is a
 way to suggest to the thread scheduler that it's a good time to switch from the current thread to another thread
 to ensure a smooth running of parallel tasks. However, the exact behavior of Thread.yield() is platform-dependent,
 and it's generally used in a debugging/testing scenario rather than in production code.
 */
public class ThreadYieldExample {
    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("I am producer: Producing Item " + i);
                Thread.yield();
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("I am consumer: Consuming Item " + i);
                Thread.yield();
            }
        });

        producer.start();
        consumer.start();
    }
}
