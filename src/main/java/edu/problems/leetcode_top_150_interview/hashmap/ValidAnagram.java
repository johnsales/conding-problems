package edu.problems.leetcode_top_150_interview.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // char[] sChars = s.toLowerCase().toCharArray();
        // char[] tChars = t.toLowerCase().toCharArray();

        // Arrays.sort(sChars);
        // Arrays.sort(tChars);

        // return Arrays.equals(sChars, tChars);
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Character c : t.toCharArray()){
            if(map.getOrDefault(c, 0) == 0)
                return false;
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        return true;
    }
}
