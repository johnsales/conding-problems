package edu.problems.leetcode_interview_crash_course_dsa.arrays_strings.sliding_window;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
    /**
     You are given an integer array nums consisting of n elements, and an integer k.

     Find a contiguous subarray whose length is equal to k that has the maximum average value and return
     this value. Any answer with a calculation error less than 10-5 will be accepted.
     */
    public static double findMaxAverage(int[] nums, int k) {
        if(k > nums.length) return Double.MIN_VALUE;

        double sum = 0;
        double ans = 0.0;

        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        ans = sum/k;
        for(int i = k; i < nums.length; i++){
            sum += nums[i] - nums[i-k];
            ans = Math.max(ans,sum/k);
        }

        return ans;
    }
}
