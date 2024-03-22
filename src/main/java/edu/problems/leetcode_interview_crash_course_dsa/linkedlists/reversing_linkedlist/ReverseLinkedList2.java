package edu.problems.leetcode_interview_crash_course_dsa.linkedlists.reversing_linkedlist;

/**
 Given the head of a singly linked list and two integers left and right where left <= right,
 reverse the nodes of the list from position left to position right, and return the reversed list.
 */
public class ReverseLinkedList2 {

    //Approach 3
    public ListNode reverseBetweenv3(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Create a dummy node and set its next to the head of the list
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // Initialize a pointer 'prev' to the dummy node
        ListNode prev = dummy;

        // Move 'prev' to the node before the sublist to be reversed
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Initialize 'current' pointer to the first node in the sublist to be reversed
        ListNode current = prev.next;
        ListNode nextNode;

        // Reverse the sublist from 'left' to 'right'
        for (int i = left; i < right; i++) {
            // Store the next node temporarily
            nextNode = current.next;

            // Move 'current' to the next node in the original list
            current.next = nextNode.next;

            // Insert 'nextNode' after 'prev' to reverse the sublist
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        // Return the head of the modified list
        return dummy.next;
    }

    //Approach 2: Iterative Link Reversal: O(n) and O(1)
    public ListNode reverseBetweenv2(ListNode head, int m, int n) {

        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }

    //Approach 1: Recursion: O(n) and O(n)

    // Object level variables since we need the changes
    // to persist across recursive calls and Java is pass by value.
    private boolean stop;
    private ListNode left;

    public void recurseAndReverse(ListNode right, int m, int n) {

        // base case. Don't proceed any further
        if (n == 1) {
            return;
        }

        // Keep moving the right pointer one step forward until (n == 1)
        right = right.next;

        // Keep moving left pointer to the right until we reach the proper node
        // from where the reversal is to start.
        if (m > 1) {
            this.left = this.left.next;
        }

        // Recurse with m and n reduced.
        this.recurseAndReverse(right, m - 1, n - 1);

        // In case both the pointers cross each other or become equal, we
        // stop i.e. don't swap data any further. We are done reversing at this
        // point.
        if (this.left == right || right.next == this.left) {
            this.stop = true;
        }

        // Until the boolean stop is false, swap data between the two pointers
        if (!this.stop) {
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;

            // Move left one step to the right.
            // The right pointer moves one step back via backtracking.
            this.left = this.left.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }

    class ListNode{
        int val;
        ListNode next;

         ListNode(int val) { this.val = val; }

    }
}
