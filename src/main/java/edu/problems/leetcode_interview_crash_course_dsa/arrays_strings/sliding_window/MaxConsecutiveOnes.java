package edu.problems.leetcode_interview_crash_course_dsa.arrays_strings.sliding_window;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(longestOnes2(new int[]{1,0,0,0},1));
    }

    /**
     Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array
     if you can flip at most k 0's.
     */
    public int longestOnes(int[] nums, int k) {
        int left = 0, ans = 0, curr = 0, countZero = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0) countZero++;
            curr++;
            while(countZero > k){
                if(nums[left] == 0){
                    countZero--;
                }
                left++;
                curr--;
            }
            ans = Math.max(ans, curr);
        }
        return ans;
    }

    //clean
    public static int longestOnes2(int[] nums, int k) {
        int left = 0, right;

        for(right = 0; right < nums.length; right++){
            if(nums[right] == 0)
                k--;
            if(k < 0){
                k += 1 - nums[left];
                left++;
            }
        }
        return right - left;
    }
}
