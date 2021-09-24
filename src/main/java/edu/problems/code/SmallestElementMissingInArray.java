package edu.problems.code;

import java.util.Set;
import java.util.TreeSet;

public class SmallestElementMissingInArray {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{7,6,5,4,2,1}));
    }

    static int solution(int[] array){
        Set<Integer> treeSet = new TreeSet<>();

        for (int element: array)
            treeSet.add(element);

        int i = 1;
        while(true){
            if(!treeSet.contains(i)){
                return i;
            }else
                i++;
        }
    }
}
