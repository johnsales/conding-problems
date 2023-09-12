package edu.problems.leetcode_top_150_interview.array_string.easy;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int leastValue = Integer.MAX_VALUE;
        int overralProfit = 0;
        int profitDay = 0;
        for(int i = 0; i < prices.length;i++){
            if(prices[i] < leastValue){
                leastValue = prices[i];
            }
            profitDay = prices[i] - leastValue;
            if(profitDay > overralProfit){
                overralProfit = profitDay;
            }

        }
        return overralProfit;
    }
}
