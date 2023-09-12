package edu.problems.leetcode_top_150_interview.two_pointers.easy;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()){
            return false;
        }
        if(s.length() == 0)
            return true;

        int sp = 0;
        for(int i = 0; i < t.length(); i++){
            if(s.charAt(sp) ==  t.charAt(i)){
                sp++;
            }
            if(sp == s.length()){
                return true;
            }
        }

        return false;
    }
}
