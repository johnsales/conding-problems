package edu.problems.interviews.bloomberg.z_outside_course;

import java.util.Stack;

public class MaxDepth {
    public int maxDepth(String s) {
        int depth = 0;
        if(s.isEmpty()) return depth;
        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
                depth = Math.max(depth, stack.size());
            }else if(c == ')'){
                stack.pop();
            }
        }

        return depth;
    }
}
