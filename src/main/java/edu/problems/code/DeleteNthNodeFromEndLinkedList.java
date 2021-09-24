package edu.problems.code;

import java.util.Arrays;
import java.util.LinkedList;

/**
 Given a linked list and an integer N, the task is to delete the Nth node from the end of the given linked list.
 Examples:

 Input: 2 -> 3 -> 1 -> 7 -> NULL, N = 1
 Output:
 The created linked list is:
 2 3 1 7
 The linked list after deletion is:
 2 3 1
 */
public class DeleteNthNodeFromEndLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1 ,2, 3, 4));
        System.out.println(deleteNthNumber(linkedList,4));
    }

    static LinkedList<Integer> deleteNthNumber(LinkedList<Integer> linkedList, int nth){
        if(linkedList.isEmpty() || nth <= 0 || nth > linkedList.size()) throw new IllegalArgumentException("Invalid argument");
        int indexDeletion = linkedList.size()-nth;
        linkedList.remove(indexDeletion);
        return linkedList;
    }
}
