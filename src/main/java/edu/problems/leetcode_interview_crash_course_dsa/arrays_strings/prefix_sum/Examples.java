package edu.problems.leetcode_interview_crash_course_dsa.arrays_strings.prefix_sum;

public class Examples {
    /**
     Example 1: Given an integer array nums, an array queries where queries[i] = [x, y] and an integer
     limit, return a boolean array that represents the answer to each query. A query is true if the sum
     of the subarray from x to y is less than limit, or false otherwise.

     For example, given nums = [1, 6, 3, 2, 7, 2], queries = [[0, 3], [2, 5], [2, 4]], and limit = 13,
     the answer is [true, false, true]. For each query, the subarray sums are [12, 14, 12].
     */
    public boolean[] answerQueries(int[] nums, int[][] queries, int limit) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            int curr = prefix[y] - prefix[x] + nums[x];
            ans[i] = curr < limit;
        }
        return ans;
    }

    /**
     Example 2: 2270. Number of Ways to Split Array

     Given an integer array nums, find the number of ways to split the array into two parts so that the
     first section has a sum greater than or equal to the sum of the second section. The second section
     should have at least one number.
     */
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;

        long[] prefix = new long[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            long leftSection = prefix[i];
            long rightSection = prefix[n - 1] - prefix[i];
            if (leftSection >= rightSection) {
                ans++;
            }
        }
        return ans;
    }

    //without an array, improves the space complexity to O(1)
    public int waysToSplitArray2(int[] nums) {
        int ans = 0;
        long leftSection = 0;
        long total = 0;

        for (int num: nums) {
            total += num;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            leftSection += nums[i];
            long rightSection = total - leftSection;
            if (leftSection >= rightSection) {
                ans++;
            }
        }
        return ans;
    }
}
