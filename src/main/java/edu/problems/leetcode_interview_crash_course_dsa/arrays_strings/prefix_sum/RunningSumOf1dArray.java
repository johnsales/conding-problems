package edu.problems.leetcode_interview_crash_course_dsa.arrays_strings.prefix_sum;

public class RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] +=  nums[i-1];
        }
        return nums;
    }
}
