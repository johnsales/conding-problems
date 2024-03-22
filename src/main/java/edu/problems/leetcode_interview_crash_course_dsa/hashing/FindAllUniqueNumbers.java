package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 Example 3: Given an integer array nums, find all the unique numbers x in nums that satisfy the following:
 x + 1 is not in nums, and x - 1 is not in nums.
 */
public class FindAllUniqueNumbers {
    public List<Integer> findNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();

        for (int num: nums) {
            numSet.add(num);
        }
        for (int num: nums) {
            if (!numSet.contains(num + 1) && !numSet.contains(num - 1)) {
                ans.add(num);
            }
        }
        return ans;
    }
}
