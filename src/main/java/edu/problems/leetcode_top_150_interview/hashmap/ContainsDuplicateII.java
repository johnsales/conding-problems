package edu.problems.leetcode_top_150_interview.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    //O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();


        for(int i =0;i< nums.length;i++){
            if(map.containsKey(nums[i])){
                if(Math.abs(i - map.get(nums[i])) <= k){
                    return true;
                }else{
                    map.put(nums[i], i);
                }
            }else{
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
