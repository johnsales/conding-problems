package edu.problems.cracking_code_interview.chapter2;

import com.fasterxml.jackson.databind.util.LinkedNode;

import java.util.*;

public class RemoveDups {

    public static void main(String[] args) {

    }

    //pseudocode
    static void removeDups(LinkedNode n){
        HashSet<Object> set = new HashSet<>();
        LinkedNode<Object> previous = null;
        while(n != null){
            if(set.contains(n.value())){
                previous.linkNext(n.next());
            }else {
                set.add(n.value());
                previous = n;
            }
            n = n.next();
        }
    }
}
