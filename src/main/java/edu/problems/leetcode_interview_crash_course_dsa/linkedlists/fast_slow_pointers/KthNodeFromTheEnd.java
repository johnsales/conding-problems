package edu.problems.leetcode_interview_crash_course_dsa.linkedlists.fast_slow_pointers;

/**
 Example 3: Given the head of a linked list and an integer k, return the Kth node from the end.

 For example, given the linked list that represents 1 -> 2 -> 3 -> 4 -> 5 and k = 2, return the node with value 4,
 as it is the 2nd node from the end.
 */
public class KthNodeFromTheEnd {
    //O(n) nad O(1)
    ListNode findNode(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    class ListNode{
        int val;
        ListNode next;
    }
}
