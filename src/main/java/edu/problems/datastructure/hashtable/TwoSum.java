package edu.problems.datastructure.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1,2},3)));
    }

    public static int[] twoSum(int[] numbers, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(numbers[i],i);
        }
        throw new IllegalArgumentException("No two sum solution.");
    }
}
