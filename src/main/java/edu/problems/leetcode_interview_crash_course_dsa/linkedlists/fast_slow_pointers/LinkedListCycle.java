package edu.problems.leetcode_interview_crash_course_dsa.linkedlists.fast_slow_pointers;

import java.util.HashSet;
import java.util.Set;

/**
 Given the head of a linked list, determine if the linked list has a cycle.

 There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 following the next pointer.
 */
public class LinkedListCycle {
    public boolean detectCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head)) {
                return true;
            }
            seen.add(head);
            head = head.next;
        }
        return false;
    }
    //O(n) and O(1)
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    class ListNode{
        int val;
        ListNode next;
    }
}
