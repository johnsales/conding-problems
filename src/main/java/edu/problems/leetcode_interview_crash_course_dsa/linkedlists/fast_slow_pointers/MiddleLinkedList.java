package edu.problems.leetcode_interview_crash_course_dsa.linkedlists.fast_slow_pointers;

/**
 Given the head of a singly linked list, return the middle node of the linked list.
 */
public class MiddleLinkedList {

    //O(n) and O(1)
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    class ListNode{
        int val;
        ListNode next;
    }
}
