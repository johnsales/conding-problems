package edu.problems.leetcode_top_150_interview.two_pointers.medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        //pointers
        int L = 0, R = height.length -1, maxArea = Integer.MIN_VALUE;
        //calculate the maxArea
        while(L < R){
            int area = Math.min(height[L], height[R]) * (R-L);
            maxArea = Math.max(maxArea, area);
            if(height[L] < height[R]){
                L++;
            }else{
                R--;
            }
        }
        return maxArea;
    }
}
