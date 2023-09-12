package edu.problems.leetcode_top_150_interview.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] sArray = s.split(" ");
        if(pattern.length() != sArray.length){
            return false;
        }
        Map<Character, String> c2s = new HashMap<>();
        Map<String, Character> s2c = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++){
            Character pChar = pattern.charAt(i);
            String sValue = sArray[i];

            if(!c2s.containsKey(pChar)){
                c2s.put(pChar,sValue);
            }
            if(!s2c.containsKey(sValue)){
                s2c.put(sValue,pChar);
            }
            if(!c2s.get(pChar).equals(sValue) || !s2c.get(sValue).equals(pChar)){
                return false;
            }
        }
        return true;
    }
}
