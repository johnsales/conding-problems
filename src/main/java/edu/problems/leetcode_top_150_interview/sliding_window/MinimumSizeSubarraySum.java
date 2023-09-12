package edu.problems.leetcode_top_150_interview.sliding_window;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int R = 0, L = 0, sum = 0, minLength = Integer.MAX_VALUE;
        while(R < nums.length){
            sum+= nums[R];
            while(sum >= target){
                minLength = Math.min(minLength, R - L + 1);
                sum -= nums[L++];
            }
            R++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
