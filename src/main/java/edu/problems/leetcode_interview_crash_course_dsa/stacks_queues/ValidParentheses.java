package edu.problems.leetcode_interview_crash_course_dsa.stacks_queues;

import java.util.Map;
import java.util.Stack;

/**
 Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 input string is valid. The string is valid if all open brackets are closed by the same type of
 closing bracket in the correct order, and each closing bracket closes exactly one open bracket.

 For example, s = "({})" and s = "(){}[]" are valid, but s = "(]" and s = "({)}" are not valid.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    //O(n) and O(n)
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()){
            switch(c){
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if(stack.isEmpty() || c != stack.pop()) return false;
            }
        }

        return stack.isEmpty();
    }
}
