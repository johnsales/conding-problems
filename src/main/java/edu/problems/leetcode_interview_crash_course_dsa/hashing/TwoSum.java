package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     Example 1: 1. Two Sum

     Given an array of integers nums and an integer target, return indices of two numbers such that they
     add up to target. You cannot use the same index twice.

     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dic = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            if (dic.containsKey(complement)) { // This operation is O(1)!
                return new int[] { i, dic.get(complement) };
            }
            dic.put(num, i);
        }
        return new int[] { -1, -1};
    }
}
