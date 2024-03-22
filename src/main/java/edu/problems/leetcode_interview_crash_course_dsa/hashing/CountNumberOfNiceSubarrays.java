package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            Map<Integer, Integer> counts = new HashMap<>();
            counts.put(0, 1);

            int ans = 0;
            int curr = 0;

            for (int num: nums) {
                curr += num % 2;
                ans += counts.getOrDefault(curr - k, 0);
                counts.put(curr, counts.getOrDefault(curr, 0) + 1);
            }

            return ans;
        }
    }
}
