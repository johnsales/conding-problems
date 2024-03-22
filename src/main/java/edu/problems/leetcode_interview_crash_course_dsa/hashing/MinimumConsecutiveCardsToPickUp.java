package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Given an integer array cards, find the length of the shortest subarray that contains at least one duplicate.
 If the array has no duplicates, return -1.
 */
public class MinimumConsecutiveCardsToPickUp {

    public int minimumCardPickupv2(int[] cards) {
        Map<Integer, Integer> dic = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            int num = cards[i];
            if (dic.containsKey(num)) {
                ans = Math.min(ans, i - dic.get(num) + 1);
            }

            dic.put(num, i);
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }

    //O(n) and O(n)
    public int minimumCardPickupv1x (int[] cards) {
        Map<Integer, List<Integer>> dic = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            int num = cards[i];
            if (!dic.containsKey(num)) {
                dic.put(num, new ArrayList<>());
            }
            dic.get(num).add(i);
        }
        int ans = Integer.MAX_VALUE;
        for (int key: dic.keySet()) {
            List<Integer> arr = dic.get(key);
            for (int i = 0; i < arr.size() - 1; i++) {
                ans = Math.min(ans, arr.get(i + 1) - arr.get(i) + 1);
            }
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }
}
