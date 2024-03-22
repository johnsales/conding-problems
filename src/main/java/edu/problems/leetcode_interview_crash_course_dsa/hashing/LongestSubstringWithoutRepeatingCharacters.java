package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    //O(n) and O(n)
    public int lengthOfLongestSubstring(String s) {
        int left = 0, ans = 0;
        Set<Character> set = new HashSet<>();
        for(int right = 0; right < s.length(); right++){
            char rightC = s.charAt(right);
            while(set.contains(rightC)){
                char leftC = s.charAt(left);
                set.remove(leftC);
                left++;
            }
            set.add(rightC);
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}
