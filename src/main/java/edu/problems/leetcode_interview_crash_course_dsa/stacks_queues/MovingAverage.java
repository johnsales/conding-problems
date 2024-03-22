package edu.problems.leetcode_interview_crash_course_dsa.stacks_queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 Given a stream of integers and a window size, calculate the moving average of all integers in the
 sliding window.

 Implement the MovingAverage class:

 MovingAverage(int size) Initializes the object with the size of the window size.
 double next(int val) Returns the moving average of the last size values of the stream.
 */
public class MovingAverage {
    int size;
    Queue<Integer> queue;
    public MovingAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        double sum = 0.0;
        if(queue.size() == size) queue.poll();
        queue.offer(val);
        for (int v:queue) {
            sum+=v;
        }
        return sum/queue.size();
    }
}
