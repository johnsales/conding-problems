package edu.problems.cracking_code_interview.chapter1;

import net.bytebuddy.TypeCache;

import java.util.Arrays;

public class CheckPermutation {
    public static void main(String[] args) {
        System.out.println("checkPermutation1: "+checkPermutation1("bac","cba"));
        System.out.println("checkPermutation2: "+checkPermutation2("bac","cba"));
    }

    // O(n log n)
    static boolean checkPermutation1(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
       char[] s1Sorted = s1.toCharArray();
       Arrays.sort(s1Sorted);
       char[] s2Sorted = s2.toCharArray();
       Arrays.sort(s2Sorted);

       for (int i = 0; i < s1Sorted.length; i++) {
           if(s1Sorted[i] != s2Sorted[i]) return false;
       }

        return true;
    }

    //O(n)
    static boolean checkPermutation2(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        int[] asciiArray = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            asciiArray[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            asciiArray[s2.charAt(i)]--;
            if(asciiArray[s2.charAt(i)] < 0) return false;
        }
        return true;
    }
}
