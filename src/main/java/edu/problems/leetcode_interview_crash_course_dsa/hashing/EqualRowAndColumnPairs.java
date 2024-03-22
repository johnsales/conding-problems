package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 Given an n x n matrix grid, return the number of pairs (R, C) where R is a row and C is a column, and R and C are
 equal if we consider them as 1D arrays.
 */
public class EqualRowAndColumnPairs {
    //If the grid has a size of n⋅n, this algorithm has a time complexity of O(n^2)
    public int equalPairs(int[][] grid) {
        Map<String, Integer> dic = new HashMap<>();
        for (int[] row: grid) {
            String key = convertToKey(row);
            dic.put(key, dic.getOrDefault(key, 0) + 1);
        }

        Map<String, Integer> dic2 = new HashMap<>();
        for (int col = 0; col < grid[0].length; col++) {
            int[] currentCol = new int[grid.length];
            for (int row = 0; row < grid.length; row++) {
                currentCol[row] = grid[row][col];
            }

            String key = convertToKey(currentCol);
            dic2.put(key, dic2.getOrDefault(key, 0) + 1);
        }

        int ans = 0;
        for (String key: dic.keySet()) {
            ans += dic.get(key) * dic2.getOrDefault(key, 0);
        }
        return ans;
    }

    public String convertToKey(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            sb.append(",");
        }
        return sb.toString();
    }
}
