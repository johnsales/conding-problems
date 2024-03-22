package edu.problems.leetcode_interview_crash_course_dsa.arrays_strings.two_pointers;

public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length -1;
        while(left < right){
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
