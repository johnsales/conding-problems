package edu.problems.leetcode_interview_crash_course_dsa.stacks_queues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 The next greater element of some element x in an array is the first greater element that is to the
 right of x in the same array.

 You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

 For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next
 greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this
 query is -1.

 Return an array ans of length nums1.length such that ans[i] is the next greater element as described
 above.
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int n: nums2){
            while(!stack.isEmpty() && n > stack.peek()){
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }

        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
