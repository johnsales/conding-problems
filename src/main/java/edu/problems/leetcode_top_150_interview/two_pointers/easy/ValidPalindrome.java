package edu.problems.leetcode_top_150_interview.two_pointers.easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = dataCleanUp(s);
        int left = 0, right = s.length() -1;
        while(s.length() > 0 && left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String dataCleanUp(String s){
        s = s.toLowerCase();
        s = s.trim();
        s = s.replaceAll("[^a-z0-9]","");
        return s;
    }
}
