package edu.problems.leetcode_interview_crash_course_dsa.linkedlists.fast_slow_pointers;

/**
 Given the head of a sorted linked list, delete all duplicates such that each element appears
 only once. Return the linked list sorted as well.
 */
public class RemoveDuplicatesSortedList {

    //O(n) and O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while(current != null && current.next != null){
            if(current.val == current.next.val){
                current.next = current.next.next;
            } else{
                current = current.next;
            }
        }
        return head;
    }

    class ListNode{
        int val;
        ListNode next;
    }
}
