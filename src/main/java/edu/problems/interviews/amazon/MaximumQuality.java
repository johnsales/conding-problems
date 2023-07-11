package edu.problems.interviews.amazon;

import java.util.Arrays;

public class MaximumQuality {

    public static void main(String[] args) {
        int[] packets = {1, 2, 3, 4, 5};
        int channels = 2;
        int maxQuality = maximumQuality(packets, channels);
        System.out.println("Maximum sum of qualities: " + maxQuality);
    }

    public static int maximumQuality(int[] packets, int channels) {
        Arrays.sort(packets);
        //todo

        return (int) Math.ceil(1);
    }
}

