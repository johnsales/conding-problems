package edu.problems.leetcode_top_150_interview.array_string.easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String lcp = "";

        for(int i = 0; i < strs.length; i++){
            if(i == 0){
                lcp = strs[0];
                continue;
            }

            String word = strs[i];
            String tempLcp = "";
            for(int j = 0; j < word.length() && j < lcp.length(); j++){
                if(word.charAt(j) == lcp.charAt(j)){
                    tempLcp+=word.charAt(j);
                }else{
                    break;
                }
            }
            lcp = tempLcp;
        }
        return lcp;
    }
}
