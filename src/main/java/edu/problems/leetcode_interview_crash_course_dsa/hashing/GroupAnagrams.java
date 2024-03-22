package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.*;

/**
 Given an array of strings strs, group the anagrams together.

 For example, given strs = ["eat","tea","tan","ate","nat","bat"], return [["bat"],["nat","tan"],["ate","eat","tea"]].
 */
public class GroupAnagrams {

    //Given n as the length of strs and m as the average length of the strings
    // O(n⋅m⋅logm) & O(n⋅m)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String s: strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }

            groups.get(key).add(s);
        }

        return new ArrayList(groups.values());
    }
}
