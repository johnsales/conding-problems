package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you
 have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also
 jewels.

 Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
public class JewelsAndStones {
    //O(n + m) and O(n)
    public int numJewelsInStones2(String jewels, String stones) {
        Set<Character> set = jewels.chars() // This creates an IntStream
                .mapToObj(e -> (char) e) // Convert int to Character
                .collect(Collectors.toSet()); // Collect as Set
        int count = 0;
        for (Character c: stones.toCharArray()) {
            if(set.contains(c)) count++;
        }
        return count;
    }
    // O(n*m) and O(n)
    public int numJewelsInStones1(String jewels, String stones) {
        int count = 0;
        for(char c : stones.toCharArray()){
            if(jewels.indexOf(c) > -1){
                count++;
            }
        }
        return count;
    }
}
