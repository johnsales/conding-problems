package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.HashSet;
import java.util.Set;

public class CheckIfSentenceIsPangram {
    public static void main(String[] args) {
        System.out.println(checkIfPangram("zonrcsnlxckptsxffbyswujpamfltvmdoxovggepknmtacrjkkorjgvgtgaiaudspnpxkwikevmjeephhiyvnoymjwjfopovscbefecnoytjxfwasabwohqujwowmakpyuuqvgfab"));
    }

    public static boolean checkIfPangram(String sentence) {
        // We iterate over 'sentence' for 26 times, one for each letter 'currChar'.
        for (int i = 0; i < 26; ++i) {
            char currChar = (char) ('a' + i);

            // If 'sentence' doesn't contain currChar, it is not a pangram.
            if(sentence.indexOf(currChar) == -1) return false;
        }
        // If we manage to find all 26 letters, it is a pangram.
        return true;
    }

    public static boolean checkIfPangram2(String sentence) {
        Set<Character> alphabet = new HashSet<>();
        for (int i = 97; i <= 122; i++) {
            alphabet.add((char)i);
        }
        for (Character c: sentence.toCharArray()) {
            alphabet.remove(c);
        }
        return alphabet.isEmpty();
    }
}
