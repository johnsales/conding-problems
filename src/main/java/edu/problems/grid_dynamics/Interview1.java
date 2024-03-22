package edu.problems.grid_dynamics;

public class Interview1 {

    //int (atomic) x long = oX123o131203...1,
    //Happens before is present: https://jenkov.com/tutorials/java-concurrency/java-happens-before-guarantee.html
    //Distributed transactions (Event-Sourcing / Saga / 2PC..)
    //Threads lifecycle
    //virtual threads - java 20/21
    //Our favorite book Java Concurrency in Practice https://www.amazon.com/Java-Concurrency-Practice-Brian-Goetz/dp/0321349601

    long value = 0;
    boolean latch = true;

    public static void main(String[] args) {
        //re-order operations / book
    }

    Thread t1 = new Thread(()->{
        value = 42;
        latch = false;
    });

    Thread t2 = new Thread(()->{
        while(latch) {
            /* empty block */
        };
        System.out.println(value);
    });

//    //both run in parallel
//    t1.start()
//    t2.start()
//
//    //waits this thread to finish before it goes to the next line
//    t1.join();
//    t2.join();

    //wait, notify ?


    /**
     * Reordering (issue in multi-threaded environments.)
     In Java, the "reordering" issue refers to the phenomenon where the compiler, runtime, or hardware may change
     the order of instructions for optimization purposes. This optimization is generally invisible at the single-thread
     level but can cause significant issues in multi-threading environments, leading to unpredictable behavior
     if proper synchronization is not used.

     One common example of reordering issues in Java involves memory visibility problems among threads.
     When threads access shared variables without proper synchronization, there's no guarantee that one thread's
     changes will be visible to another thread, due to caching and reordering optimizations.

     Due to reordering, there's a chance that the write to ready could be reordered and happen before the write to number.
     If the ReaderThread sees ready as true before number is written, it might print 0 (the default value of number)
     instead of 42.
     */
    public class ReorderingExample {

        private static boolean ready; //volatile prevents reordering issues in this simple case
        private static int number;

        private static class ReaderThread extends Thread {
            public void run() {
                while (!ready) {
                    Thread.yield();
                }
                System.out.println(number);
            }
        }

        public static void main(String[] args) {
            new ReaderThread().start();
            number = 42;
            ready = true;
        }
    }
}


