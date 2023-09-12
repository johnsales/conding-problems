package edu.problems.leetcode_top_150_interview.array_string.easy;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        int result = -1;
        if(haystack.length() <= needle.length() && !haystack.equals(needle)){
            return result;
        }


        for(int i = 0; i < haystack.length() && haystack.length() - i >= needle.length(); i++){
            int count = 0;
            for(int j = 0; j < needle.length(); j++){
                if(haystack.charAt(i+j) == needle.charAt(j)){
                    count++;
                }else{
                    break;
                }
                if(count == needle.length()){
                    result = i;
                    return result;
                }
            }
        }
        return result;
    }
}
