package edu.problems.leetcode_interview_crash_course_dsa.linkedlists.reversing_linkedlist;

public class ReversingLinkedList {

    //O(n) and O(1)
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next; // first, make sure we don't lose the next node
            curr.next = prev;              // reverse the direction of the pointer
            prev = curr;                   // set the current node to prev for the next node
            curr = nextNode;               // move on
        }
        return prev;
    }

    class ListNode{
        int val;
        ListNode next;
    }
}