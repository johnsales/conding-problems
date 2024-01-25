package edu.problems.concurrency;


/**

 # Thread Lifecycle in Java

 New: When a thread is created, but not yet started.

 Runnable: The thread is executing or ready to execute when given CPU time.

 Blocked: The thread is blocked and not eligible to run, usually waiting for a monitor lock.

 Waiting: The thread is waiting indefinitely for another thread to perform a specific action.

 Timed Waiting: The thread is waiting for another thread to perform an action for up to a specified waiting time.

 Terminated: The thread has completed its execution or has been terminated.

 */
public class ThreadExample {
    private int count = 0;

    public synchronized void increment() {
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        count++;
    }

    public static void main(String[] args) {
        ThreadExample example = new ThreadExample();
        example.doWork();
    }

    public void doWork() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count: " + count);
    }
}

