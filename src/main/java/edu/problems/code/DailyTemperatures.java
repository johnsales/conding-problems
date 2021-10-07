package edu.problems.code;


import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 Given set of temperature recorded at end of each day. Find how many days we need wait before getting next warmer
 temperature?

 arr={70,60,71,90}
 output: {2,1,1,0}
 **/
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] arr = {70,60,71,90};
        System.out.println(Arrays.toString(dailyTemperatures(arr)));
    }

    //efficient approach O(n)
    public static int[] dailyTemperatures(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] map = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            while(!stack.isEmpty() && array[stack.peek()] < array[i]){
                Integer topIndex = stack.pop();
                int diff = i - topIndex;
                map[topIndex] = diff;
            }
            stack.push(i);
        }
        //putting 0 on the remaining that there no temperature bigger after it
        while (!stack.isEmpty()){
            Integer topIndex = stack.pop();
            map[topIndex] = 0;
        }
        return map;
    }
    //brute force approach O(n2)
    public static int[] dailyTemperatures2(int[] array){
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if(array[i] < array[j]){
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
