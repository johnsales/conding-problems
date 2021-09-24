package edu.problems.code;

import java.util.HashMap;
import java.util.Map;

public class WholeMinuteDilemma {
    public static void main(String[] args) {
        WholeMinuteDilemma dilemma = new WholeMinuteDilemma();
        System.out.println(dilemma.pairsDivisibleByMinuteCounter(new int[]{40,20,60,40}));
    }

    public int pairsDivisibleByMinuteCounter(int[] times) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int time : times) {
            if (map.containsKey(60 - time % 60)) {
                count += map.get(60 - time % 60);
            }
            map.put(time % 60, map.getOrDefault(time % 60, 0) + 1);
        }
        return count;
    }
}
