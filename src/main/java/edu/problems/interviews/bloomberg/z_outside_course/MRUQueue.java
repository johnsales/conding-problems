package edu.problems.interviews.bloomberg.z_outside_course;

import java.util.ArrayList;
import java.util.List;

public class MRUQueue {

    int[] array;
    List<Integer> list;
    public MRUQueue(int n) {
        array = new int[n];
        for(int i = 0; i < array.length; i++){
            array[i] = i + 1;
        }
        list= new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            list.add(i);
        }

    }

    //O(?)
    public int fetch(int k) {
        if(k < 1) return Integer.MIN_VALUE;
        if(k > array.length) return Integer.MAX_VALUE;

        int element = array[k-1];
        for(int i = k - 1; i < array.length -1; i++){
            array[i] = array[i+1];
        }
        array[array.length -1] = element;
        return element;
    }

    //O(n)
    public int fetch_n(int k) {
        if(k < 1) return Integer.MIN_VALUE;
        if(k > array.length) return Integer.MAX_VALUE;

        int element = array[k-1];
        for(int i = k - 1; i < array.length -1; i++){
            array[i] = array[i+1];
        }
        array[array.length -1] = element;
        return element;
    }

    //O(n)
    public int fetch_n2(int k) {
        if(k < 1) return Integer.MIN_VALUE;
        if(k > list.size()) return Integer.MAX_VALUE;
        int element = list.remove(k -1);
        list.add(element);
        return element;
    }

}
