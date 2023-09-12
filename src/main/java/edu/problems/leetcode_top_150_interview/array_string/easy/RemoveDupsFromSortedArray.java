package edu.problems.leetcode_top_150_interview.array_string.easy;

public class RemoveDupsFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int k =  nums.length > 0 ? 1 : 0;
        for(int i = 0; i < nums.length;i++){
            if(nums[i] != nums[k-1])
                nums[k++] = nums[i];
        }
        return k;
    }
}
