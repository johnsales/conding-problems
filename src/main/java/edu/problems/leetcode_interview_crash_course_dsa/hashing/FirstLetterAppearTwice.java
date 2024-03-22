package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 Example 2: 2351. First Letter to Appear Twice

 Given a string s, return the first character to appear twice. It is guaranteed that the input will
 have a duplicate character.
 */
public class FirstLetterAppearTwice {

    //O(n)
    public char repeatedCharacter(String s) {
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen.contains(c)) {
                return c;
            }
            seen.add(c);
        }
        return ' ';
    }
    //O(n^2)
    public char repeatedCharacter2(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == c) {
                    return c;
                }
            }
        }
        return ' ';
    }
}
