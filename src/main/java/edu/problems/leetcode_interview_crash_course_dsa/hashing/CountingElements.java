package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr.
 If there are duplicates in arr, count them separately.
 */
public class CountingElements {
    //O(N) & O(N)
    public int countElements(int[] arr) {
        Set<Integer> hashSet = new HashSet<>();
        for (int x : arr)
            hashSet.add(x);

        int count = 0;
        for (int x : arr) {
            if (hashSet.contains(x + 1)) {
                count++;
            }
        }
        return count;
    }

    //O(NlogN) && O(1)
    public int countElements2(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int runLength = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                if (arr[i - 1] + 1 == arr[i]) {
                    count += runLength;
                }
                runLength = 0;
            }
            runLength++;
        }
        return count;
    }
}
