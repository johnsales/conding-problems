package edu.problems.leetcode_interview_crash_course_dsa.stacks_queues;

import java.util.Stack;

/**
 Given a string s of lower and upper case English letters.

 A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

 0 <= i <= s.length - 2
 s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
 To make the string good, you can choose two adjacent characters that make the string bad and
 remove them. You can keep doing this until the string becomes good.

 Return the string after making it good. The answer is guaranteed to be unique under the given
 constraints.

 Notice that an empty string is also good.
 */
public class MakeTheStringGreat {
    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
        System.out.println(makeGood("abBAcC"));
        System.out.println(makeGood("s"));
    }
    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (Character c: s.toCharArray()) {
            if(!stack.isEmpty() && Math.abs(stack.peek() - c) == 32)
                stack.pop();
            else
                stack.push(c);
        }

        for (Character c: stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
