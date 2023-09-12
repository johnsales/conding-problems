package edu.problems.leetcode_top_150_interview.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    //best space performance
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }

    //best time performance
    public class Solution {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while(head != null){
                if(set.contains(head)){
                    return true;
                }
                set.add(head);
                head = head.next;
            }
            return false;
        }
    }

    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
}
