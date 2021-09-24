package edu.problems.code;

public class LengthOfLongestSubstringDistinct {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
    }

    public static int lengthOfLongestSubstring(String string) {
        StringBuilder builder = new StringBuilder();
        int minSubString = 0;
        for (int i = 0; i < string.length(); i++) {
            for (int j = i; j < string.length(); j++) {
                if(builder.toString().indexOf(string.charAt(j)) >= 0) {
                    if(builder.length() > minSubString) minSubString = builder.length();
                    builder.setLength(0);
                    break;
                } else {
                    builder.append(string.charAt(j));
                }
            }
            if(builder.length() > minSubString) minSubString = builder.length();
        }
        return minSubString;
    }
}
