package edu.problems.concurrency;

import java.util.LinkedList;
import java.util.Queue;

/**
 Sample Scenario: Producer-Consumer Problem

 The Producer-Consumer problem is a classic example of concurrency control.
 The producer creates items and puts them in a buffer, while the consumer removes items from the buffer.

 */
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    Queue<Integer> buffer = new LinkedList<>();
    int capacity = 5; // smaller buffer for testing

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (buffer.size() == capacity) {
                    System.out.println("Buffer is full, producer is waiting.");
                    wait();
                    System.out.println("Producer resumed.");
                }
                buffer.add(value);
                System.out.println("Produced: " + value);
                value++;
                notify();
                Thread.sleep(1000); // slower production for testing
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (buffer.isEmpty()) {
                    System.out.println("Buffer is empty, consumer is waiting.");
                    wait();
                    System.out.println("Consumer resumed.");
                }
                int val = buffer.poll();
                System.out.println("Consumed: " + val);
                notify();
                Thread.sleep(500); // faster consumption for testing
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }
}

