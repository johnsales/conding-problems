package edu.problems.leetcode_interview_crash_course_dsa.arrays_strings.prefix_sum;

/**
 Given an array of integers nums, you start with an initial positive value startValue.
 In each iteration, you calculate the step by step sum of startValue plus elements in nums
 (from left to right).
 Return the minimum positive value of startValue such that the step by step sum is never less than 1.
 */
public class MinimumValueToGetPositiveStepByStepSum {
    //Complexity O(n) and O(1)
    public int minStartValue(int[] nums) {
        int sum = 0;
        int startValue = 1;
        for(int i = 0; i < nums.length; i++){
            sum+= nums[i];
            startValue = Math.min(startValue, sum > 0 ? sum : sum -1 );
        }
        return Math.abs(startValue);
    }
}
