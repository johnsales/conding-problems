package edu.problems.concurrency;

public class ThreadLifecycleDemo {

    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                // Thread is Runnable
                Thread.sleep(1000); // Thread goes to Timed Waiting
                synchronized (lock) {
                    while (!Thread.interrupted()) {
                        lock.wait(); // Thread goes to Waiting
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        System.out.println("State after creation: " + thread.getState()); // NEW

        thread.start();
        System.out.println("State after start(): " + thread.getState()); // RUNNABLE

        Thread.sleep(500); // Main thread sleeps, allowing the new thread to run and sleep
        System.out.println("State after 500ms: " + thread.getState()); // TIMED_WAITING

        synchronized (lock) {
            Thread.sleep(1000); // Main thread sleeps, the new thread enters waiting
            System.out.println("State in waiting: " + thread.getState()); // WAITING
            lock.notify(); // Notify the waiting thread
        }

        thread.interrupt(); // Interrupt to finish the thread
        thread.join(); // Wait for the thread to die
        System.out.println("State after completion: " + thread.getState()); // TERMINATED
    }
}

