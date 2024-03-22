package edu.problems.leetcode_interview_crash_course_dsa.stacks_queues;

import java.util.Stack;

/**
 Given an array of integers temperatures that represents the daily temperatures, return an array
 answer such that answer[i] is the number of days you have to wait after the ith day to get a
 warmer temperature. If there is no future day that is warmer, have answer[i] = 0 instead.
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        return answer;
    }
}
