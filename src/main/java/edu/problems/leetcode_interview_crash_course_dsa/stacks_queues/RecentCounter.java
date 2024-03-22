package edu.problems.leetcode_interview_crash_course_dsa.stacks_queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 Implement the RecentCounter class. It should support ping(int t), which records a call at time t,
 and then returns an integer representing the number of calls that have happened in the
 range [t - 3000, t]. Calls to ping will have increasing t.
 */
public class RecentCounter {
    private Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t){
        while(!queue.isEmpty() && queue.peek() < t - 3000){
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }
}
