package edu.problems.leetcode_interview_crash_course_dsa.linkedlists.fast_slow_pointers;

public class GetMiddle {
    int getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.val;
    }

    class ListNode{
        int val;
        ListNode next;
    }
}
