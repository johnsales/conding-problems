package edu.problems.algorithms;

import java.util.PriorityQueue;

/**
 Theory: This is a typical problem pattern where you're asked to find the top/smallest K elements of a
 given set. This can be efficiently solved using a Heap.

 Pattern: Use a Min-Heap for "Top K" problems and a Max-Heap for "Smallest K" problems.

 Java Example (Finding the Kth largest element using a Min-Heap):
 */
public class TopKElements {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // Min-Heap
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

}
