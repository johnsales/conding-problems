package edu.problems.interviews.bloomberg.z_outside_course;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int index = 0;

        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){
                int count =0;
                while(Character.isDigit(s.charAt(index))){
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
                counts.push(count);
            }else if(s.charAt(index) == '['){
                resultStack.push(result.toString());
                result = new StringBuilder();
                index++;
            }else if(s.charAt(index) == ']'){
                StringBuilder temp = new StringBuilder(resultStack.pop());
                int count = counts.pop();
                for(int i = 0; i < count; i++){
                    temp.append(result.toString());
                }
                result = temp;
                index++;
            }else{
                result.append(s.charAt(index));
                index++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        //System.out.println(solution.decodeString("3[a]2[bc]")); // Output: "aaabcbc"
        System.out.println(solution.decodeString("3[a2[c]]")); // Output: "accaccacc"
        //System.out.println(solution.decodeString("2[abc]3[cd]ef")); // Output: "abcabccdcdcdef"
    }
}
