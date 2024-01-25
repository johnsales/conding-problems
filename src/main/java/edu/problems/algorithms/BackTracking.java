package edu.problems.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 Theory: It's an algorithmic paradigm that tries different solutions until finds one that works.
 It's used for all possible search problems.

 Pattern: Make a choice and proceed with recursive calls. If this choice doesn't lead to a solution,
 undo the choice (backtrack) and make a different choice.

 Java Example (Generate all possible permutations):
 */
public class BackTracking {

    //Code 1
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums){
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else{
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    //Code 2
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}
