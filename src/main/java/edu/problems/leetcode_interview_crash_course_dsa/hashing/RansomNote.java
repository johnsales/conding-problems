package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from
 magazine and false otherwise.

 Each letter in magazine can only be used once in ransomNote.
 */
public class RansomNote {
    //O(n + m) & O(m)
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c: ransomNote.toCharArray()){
            if(map.containsKey(c) && map.get(c) > 0){
                map.put(c, map.get(c) -1);
                continue;
            }
            return false;
        }
        return true;
    }
}
