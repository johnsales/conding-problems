package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

 You can use each character in text at most once. Return the maximum number of instances that can be formed.
 */
public class MaximumNumberOfBalloons {

    //O(N) and O(1)
    public int maxNumberOfBalloonsv2(String text) {
        int bCount = 0, aCount = 0, lCount = 0, oCount = 0, nCount = 0;

        // Count the frequencey of all the five characters
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'b') {
                bCount++;
            } else if (text.charAt(i) == 'a') {
                aCount++;
            } else if (text.charAt(i) == 'l') {
                lCount++;
            } else if (text.charAt(i) == 'o') {
                oCount++;
            } else if (text.charAt(i) == 'n') {
                nCount++;
            }
        }

        // Find the potential of each character.
        // Except for 'l' and 'o' the potential is equal to the frequency.
        lCount = lCount / 2;
        oCount = oCount / 2;

        // Find the bottleneck.
        return Math.min(bCount, Math.min(aCount, Math.min(lCount, Math.min(oCount, nCount))));
    }

    //O(n) and O(n)
    public int maxNumberOfBalloonsv1(String text) {
        Map<Character, Integer> map = new HashMap<>();
        char a = 'a',b = 'b',l = 'l',o = 'o',n = 'n';
        map.put(b,0);
        map.put(a,0);
        map.put(l,0);
        map.put(o,0);
        map.put(n,0);


        for(char c : text.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int result = 0;
        while(true){
            if(map.get(b) == 0|| map.get(a) == 0 || map.get(l) < 2 || map.get(o) < 2 || map.get(n) == 0)
                break;

            map.put(b, map.get(b) - 1);
            map.put(a, map.get(a) - 1);
            map.put(l, map.get(l) - 2);
            map.put(o, map.get(o) - 2);
            map.put(n, map.get(n) - 1);
            result++;
        }
        return result;
    }
}
