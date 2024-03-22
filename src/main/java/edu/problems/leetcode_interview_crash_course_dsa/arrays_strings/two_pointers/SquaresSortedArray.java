package edu.problems.leetcode_interview_crash_course_dsa.arrays_strings.two_pointers;

import java.util.Arrays;

public class SquaresSortedArray {
    public int[] sortedSquares(int[] nums) {
        for(int i =0; i < nums.length; i++){
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
