package edu.problems.leetcode_top_150_interview.hashmap;

public class HappyNumber {
    public boolean isHappy(int n) {
        int s = n, f = n;

        do{
            s = compute(s);
            f = compute(compute(f));

            if(s == 1 || f == 1) return true;
        }while(s != f);

        return false;
    }

    public int compute(int n){
        int sum = 0;
        while(n != 0){
            sum+= (n%10)*(n%10);
            n/=10;
        }
        return sum;
    }
}
