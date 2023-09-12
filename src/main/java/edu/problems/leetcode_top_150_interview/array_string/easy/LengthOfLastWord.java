package edu.problems.leetcode_top_150_interview.array_string.easy;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int lastWord = -1;
        String[] words = s.split(" ");
        return words[words.length-1].length();
    }
}
