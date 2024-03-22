package edu.problems.leetcode_interview_crash_course_dsa.arrays_strings.sliding_window;

public class Examples {


    /**
        Example 1: Given an array of positive integers nums and an integer k, find the length of the
        longest subarray whose sum is less than or equal to k. This is the problem we have been talking
        about above. We will now formally solve it.
     */
    public int findLength(int[] nums, int k) {
        int left = 0;
        int curr = 0; // curr is the current sum of the window
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            curr += nums[right];
            while (curr > k) {
                curr -= nums[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    /**
     Example 2: You are given a binary string s (a string containing only "0" and "1"). You may choose up
     to one "0" and flip it to a "1". What is the length of the longest substring achievable that contains
     only "1"?

     For example, given s = "1101100111", the answer is 5. If you perform the flip at index 2, the string
     becomes 1111100111.
     */
    public int findLength(String s) {
        // curr is the current number of zeros in the window
        int left = 0;
        int curr = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right)== '0') {
                curr++;
            }
            while (curr > 1) {
                if (s.charAt(left) == '0') {
                    curr--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    /**
     Example 3: 713. Subarray Product Less Than K.

     Given an array of positive integers nums and an integer k, return the number of subarrays where the
     product of all the elements in the subarray is strictly less than k.

     For example, given the input nums = [10, 5, 2, 6], k = 100, the answer is 8. The subarrays with
     products less than k are:

     [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int ans = 0;
        int left = 0;
        int curr = 1;

        for (int right = 0; right < nums.length; right++) {
            curr *= nums[right];
            while (curr >= k) {
                curr /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }

    /**
     Example 4: Given an integer array nums and an integer k, find the sum of the subarray with the
     largest sum whose length is k.
     */
    public int findBestSubarray(int[] nums, int k) {
        int curr = 0;
        for (int i = 0; i < k; i++) {
            curr += nums[i];
        }

        int ans = curr;
        for (int i = k; i < nums.length; i++) {
            curr += nums[i] - nums[i - k];
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}
