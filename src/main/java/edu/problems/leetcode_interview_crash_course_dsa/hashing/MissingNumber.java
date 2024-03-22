package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 Given an array nums containing n distinct numbers in the range [0, n], return the only number in
 the range that is missing from the array.
 */
public class MissingNumber {

    //O(n) & O(1)
    public int missingNumber(int[] nums) {
        //int expectedSum = nums.length*(nums.length + 1)/2;
        int expectedSum = 0;
        for (int i = 0; i <= nums.length; i++)
            expectedSum += i;

        int actualSum = 0;
        for (int n: nums)
            actualSum+=n;

        return expectedSum - actualSum;
    }

    //O(n) & O(n)
    public int missingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        for(int i = 0; i <= nums.length; i++){
            if(!set.contains(i)) return i;
        }
        return -1;
    }
}
