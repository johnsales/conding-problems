package edu.problems.concurrency;

/**
 Thread.join(): This method is an instance method of the Thread class that causes the current thread to wait until
 the thread on which join has been called completes its execution. If join() is called on a thread instance, the
 currently executing thread will block until the specified thread terminates, either normally or through an exception.
 Optionally, join() can be called with a specified timeout period.
 */
public class ThreadJoinExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2: " + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread1.start();
        thread1.join(); // Waits for thread1 to die before continuing
        thread2.start();
    }
}
