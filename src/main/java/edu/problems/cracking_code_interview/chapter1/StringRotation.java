package edu.problems.cracking_code_interview.chapter1;

import java.util.Arrays;

public class StringRotation {
    public static void main(String[] args) {
        System.out.println(isRotation("cat","atc"));
    }

    static boolean isRotation(String s1, String s2){
        if(s1.length() == s2.length() && s1.length() > 0){
            String s1s1 = s1+s1;
            return s1s1.contains(s2);
        }
        return false;
    }
    
    static boolean contains(String source, String target){
        for (int i = 0; i <= source.length() - target.length(); i++) {
            if(source.startsWith(target, i)){
                return true;
            }
        }
        return false;
    }
}
