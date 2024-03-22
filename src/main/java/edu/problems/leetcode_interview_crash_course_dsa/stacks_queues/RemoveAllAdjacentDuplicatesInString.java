package edu.problems.leetcode_interview_crash_course_dsa.stacks_queues;

import java.util.Stack;

/**
 You are given a string s. Continuously remove duplicates (two of the same character beside each
 other) until you can't anymore. Return the final string after this.

 For example, given s = "abbaca", you can first remove the "bb" to get "aaca". Next, you can remove
 the "aa" to get "ca". This is the final answer.
 */
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop(); // Remove the top element if it's the same as the current character
            } else {
                stack.push(c); // Add the current character to the stack
            }
        }

        // Rebuild the string from the stack
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    //without stack
    public String removeDuplicates2(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == c) {
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(c);
            }
        }

        return stack.toString();
    }

}
