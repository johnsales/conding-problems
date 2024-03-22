package edu.problems.leetcode_interview_crash_course_dsa.stacks_queues;

import java.util.Stack;

/**
 Given two strings s and t, return true if they are equal when both are typed into empty text editors.
 '#' means a backspace character.

 For example, given s = "ab#c" and t = "ad#c", return true. Because of the backspace, the strings
 are both equal to "ac".
 */
public class BackspaceStringCompare {
    //v2
    // time and space complexity linear with the input sizes (s + t)
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public String build(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c != '#') {
                stack.append(c);
            } else if (stack.length() > 0) {
                stack.deleteCharAt(stack.length() - 1);
            }
        }

        return stack.toString();
    }

    //v1
    public boolean backspaceComparev1(String s, String t) {
        Stack<Character> stackS = new Stack();
        Stack<Character> stackT = new Stack();

        for(char c : s.toCharArray()){
            if(!stackS.isEmpty() && c == '#'){
                stackS.pop();
            }else{
                stackS.push(c);
            }
        }
        for(char c : t.toCharArray()){
            if(!stackT.isEmpty() && c == '#'){
                stackT.pop();
            }else{
                stackT.push(c);
            }
        }

        return stackS.equals(stackT);
    }
}
