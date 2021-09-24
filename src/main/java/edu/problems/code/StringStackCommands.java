package edu.problems.code;


import java.util.EmptyStackException;
import java.util.Stack;

public class StringStackCommands {

    public static void main(String[] args) {
        System.out.println(solution("5 2"));
    }

    public static int solution(String s) {

        String[] ops = s.split(" ");
        Stack<Integer> stack = new Stack<>();
        int top1, top2, res;

        try {
            for (String op : ops) {
                switch (op) {
                    case "POP":
                        stack.pop();
                        break;
                    case "DUP":
                        stack.push(stack.peek());
                        break;
                    case "-":
                        top1 = stack.pop();
                        top2 = stack.pop();
                        res = top1 - top2;
                        if (res < 0) {
                            return -1;
                        }
                        stack.push(res);
                    case "+":
                        top1 = stack.pop();
                        top2 = stack.pop();
                        res = top1 + top2;
                        if (res > Math.pow(2, 20) - 1) {
                            return -1;
                        }
                        stack.push(res);
                        break;
                    default:
                        stack.push(Integer.valueOf(op));
                        break;
                }
            }
            return stack.pop();
        } catch (EmptyStackException e) {
            return -1;
        }
    }
}
