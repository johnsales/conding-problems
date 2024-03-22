package edu.problems.interviews.bloomberg.z_outside_course;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    public static void main(String[] args) {
        TwoCityScheduling tc = new TwoCityScheduling();
        int[][] costs = new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        int[][] costs2 = new int[][]{{10,20},{30,200},{400,50},{30,20}};
        int[][] costs3 = new int[][]{{10,20},{30,200},{400,50},{30,20}};
        tc.twoCitySchedCost(costs3);
    }

    /**
     * You need to fly 2n people to two cities (A and B) in such a way that exactly n people arrive in
     * each city, while minimizing the total cost of flying everyone.
     */
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparing(a -> (a[0] - a[1])));
        int sum = 0;
        for(int i = 0; i < costs.length; i ++){
            if(i < costs.length/2)
                sum+= costs[i][0];
            else
                sum+= costs[i][1];
        }
        return sum;
    }
}
