package edu.problems.leetcode_interview_crash_course_dsa.linkedlists.reversing_linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 1. Find the middle of the linked list using the fast and slow pointer technique from the previous
 article.
 2. Once at the middle of the linked list, perform a reversal. Basically, reverse only the second
 half of the list.
 3. After reversing the second half, every node is spaced n / 2 apart from its pair node, where n
 is the number of nodes in the list which we can find from step 1.
 4. With that in mind, create another fast pointer n / 2 ahead of slow. Now, just iterate n / 2 times
 from head to find every pair sum slow.val + fast.val.
 */
public class MaximumTwinSumLinkedList {

    //Approach 3: Reverse Second Half In Place: O(n) and O(1)
    public int pairSumv3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Get middle of the linked list.
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse second half of the linked list.
        ListNode nextNode, prev = null;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        ListNode start = head;
        int maximumSum = 0;
        while (prev != null) {
            maximumSum = Math.max(maximumSum, start.val + prev.val);
            prev = prev.next;
            start = start.next;
        }

        return maximumSum;
    }

    //Approach 2: Using Stack: O(n) and O(n)
    public int pairSumv2(ListNode head) {
        ListNode current = head;
        Stack<Integer> st = new Stack<Integer>();

        while (current != null) {
            st.push(current.val);
            current = current.next;
        }

        current = head;
        int size = st.size(), count = 1;
        int maximumSum = 0;
        while (count <= size / 2) {
            maximumSum = Math.max(maximumSum, current.val + st.peek());
            current = current.next;
            st.pop();
            count++;
        }

        return maximumSum;
    }

    //Approach 1: Using List Of Integers: O(n) and O(n)
    public int pairSum(ListNode head) {
        ListNode current = head;
        List<Integer> values = new ArrayList<>();

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        int i = 0, j = values.size() - 1;
        int maximumSum = 0;
        while (i < j) {
            maximumSum = Math.max(maximumSum, values.get(i) + values.get(j));
            i++;
            j--;
        }
        return maximumSum;
    }

    class ListNode{
        int val;
        ListNode next;
    }
}
