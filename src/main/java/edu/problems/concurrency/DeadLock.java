package edu.problems.concurrency;



public class DeadLock {
    String resource1 = "resource1";
    String resource2 = "resource2";

    Thread thread1 = new Thread(() -> {
        synchronized(resource1){
            try {Thread.sleep(1);}catch (Exception e){}
            synchronized (resource2){ System.out.println("Thread 2: Locked resource 1");}
        }
    });
    Thread thread2 = new Thread(() -> {
        synchronized(resource2){
            try {Thread.sleep(1);}catch (Exception e){}
            synchronized (resource1){ System.out.println("Thread 1: Locked resource 1");}
        }
    });

    //Avoiding Deadlocks: Example
    public void doTask1() {
        synchronized (resource1) {
            synchronized (resource2) {
                System.out.println("doTask1");
            }
        }
    }
    public void doTask2() {
        synchronized (resource1) { // Always lock in the same order !!!
            synchronized (resource2) {
                System.out.println("doTask2");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        //creating deadlocks
        //deadLock.thread1.start();
        //deadLock.thread2.start();

        //avoiding deadlocks
        deadLock.doTask1();
        deadLock.doTask2();
    }
}
