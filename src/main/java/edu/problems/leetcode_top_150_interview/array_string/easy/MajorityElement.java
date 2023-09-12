package edu.problems.leetcode_top_150_interview.array_string.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int majority = 0;//default value?
        for(int num : nums){
            int getDefault = map.getOrDefault(num, 0) + 1;
            map.put(num, getDefault);
            if(getDefault > nums.length /2){
                majority = num;
                break;
            }
        }
        return majority;
    }
}
