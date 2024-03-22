package edu.problems.interviews.bloomberg.z_outside_course;

public class FlattenMultilevelDoublyLinkedList {
    public static void main(String[] args) {
        // Creating nodes
        Node node1 = new Node();
        node1.val = 1;
        Node node2 = new Node();
        node2.val = 2;
        Node node3 = new Node();
        node3.val = 3;
        Node node4 = new Node();
        node4.val = 4;
        Node node5 = new Node();
        node5.val = 5;

        // Connecting nodes to form a multilevel list
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node2.child = node4; // node2 has a child node4
        node3.prev = node2;
        node4.next = node5;
        node5.prev = node4;

        // Flattening the list
        FlattenMultilevelDoublyLinkedList solution = new FlattenMultilevelDoublyLinkedList();
        Node flattenedHead = solution.flatten(node1);

        // Printing the flattened list
        Node current = flattenedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    //time: O(N) & space: O(1)
    public Node flatten(Node head) {
        if (head == null) return null;

        Node current = head;
        while (current != null) {
            if (current.child != null) {
                // If the current node has a child, we need to find the end of the child list
                // and connect it to current.next
                Node child = current.child;
                while (child.next != null) {
                    child = child.next;
                }
                // Connect the end of the child list to the next node in the main list
                child.next = current.next;
                if (current.next != null) current.next.prev = child;

                // Connect the current node to the child and vice versa
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
            }
            current = current.next;
        }
        return head;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
