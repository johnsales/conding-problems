package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 Given an integer array nums, return the largest integer that only occurs once. If no integer occurs once, return -1.
 */
public class LargestUniqueNumber {

    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = -1;
        for(int key : map.keySet()){
            int value = map.get(key);
            if(value == 1){
                result = Math.max(result, key);
            }
        }

        return result;
    }
}
