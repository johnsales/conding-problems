package edu.problems.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

    /**

     Problem: the zoom wants 4 employees to work in parallel, but if one finish a specific task first,
     he needs to wait for the others before going to the net task;
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        ZooManager zooManager = new ZooManager();
        CyclicBarrier c1 = new CyclicBarrier(4);
        CyclicBarrier c2 = new CyclicBarrier(4, ()-> System.out.println("Cage Cleaned!"));

        try {
            for (int i = 0; i < 4; i++) {
                service.submit(() -> zooManager.performTasks(c1,c2));
            }
        }finally {
            if(service != null) service.shutdown();
        }
    }

    static class ZooManager{
        public void removeLion(){
            System.out.println(Thread.currentThread().getId() + " Removing Lion");
        }
        public void cleanCage(){
            System.out.println(Thread.currentThread().getId() + " Cleaning Cage");
        }
        public void addLion(){
            System.out.println(Thread.currentThread().getId() + " Adding Lion");
        }
        public void performTasks(CyclicBarrier c1, CyclicBarrier c2){
            try {
                removeLion();
                c1.await();
                cleanCage();
                c2.await();
                addLion();
            } catch (BrokenBarrierException | InterruptedException e) {
               //Handle Exception
            }
        }
    }
}
