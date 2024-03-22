package edu.problems.leetcode_interview_crash_course_dsa.arrays_strings.prefix_sum;

import java.util.Arrays;

/**
 You are given a 0-indexed array nums of n integers, and an integer k.

 The k-radius average for a subarray of nums centered at some index i with the radius k is the average
 of all elements in nums between the indices i - k and i + k (inclusive). If there are less than k
 elements before or after the index i, then the k-radius average is -1.

 Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray
 centered at index i.

 The average of x elements is the sum of the x elements divided by x, using integer division.
 The integer division truncates toward zero, which means losing its fractional part.

 For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75,
 which truncates to 2.
 */
public class KRadiusSubarrayAverages {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6, 3}, 3)));
    }

    public static int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i-k < 0 || i+k >= nums.length){
                result[i] = -1;
            } else{
                long sum = 0;
                for(int j = i - k; j <= i + k; j++){
                    sum += nums[j];
                }
                result[i] = (int)(sum/(k*2+1));
            }
        }
        return result;
    }

    public int[] getAverages2(int[] nums, int k) {
        if(k == 0) return nums;

        int windowSize = 2 * k + 1;
        long windowSum = 0;
        int[] averages = new int[nums.length];
        Arrays.fill(averages,-1);

        if(windowSize > nums.length) return averages;

        for(int i = 0; i < windowSize; ++i){
            windowSum += nums[i];
        }
        averages[k] = (int)(windowSum/windowSize);

        // Iterate on rest indices which have at least 'k' elements on its left and right sides.
        for(int i = windowSize; i < nums.length; ++i){
            // We remove the discarded element and add the new element to get current window sum. 'i' is the index
            // of new inserted element, and 'i - (window size)' is the index of the last removed element.
            windowSum = windowSum - nums[i - windowSize] + nums[i];
            averages[i-k] = (int) (windowSum/windowSize);
        }

        return averages;
    }
}
//7, 4, 3, 9, 1, 8, 5 / 7 = 5
