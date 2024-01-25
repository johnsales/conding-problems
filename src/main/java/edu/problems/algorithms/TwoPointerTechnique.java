package edu.problems.algorithms;

public class TwoPointerTechnique {
    public static void main(String[] args) {

    }

    /**
     This problem involves finding two numbers in a sorted array that add up to a specific target sum.
     The array is assumed to be sorted in ascending order. The goal is to determine if there are two
     numbers in the array whose sum is equal to the given target.
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] {left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1}; // return an empty result if no pair is found
    }
}
