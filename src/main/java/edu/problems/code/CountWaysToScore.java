package edu.problems.code;

public class CountWaysToScore {

    // Driver code
    public static void main (String[] args) {
        int n = 6;
        System.out.println("Count for "+n+" is "+countWaysToScore(n));
    }

    public static int countWaysToScore(int score) {
        int safety = 2, fieldGoal = 3, touchDown = 6, touchDownWithExtra = 8;

        int table[] = new int[score+1], i;
        table[0] = 1;

        for (i = safety; i <= score; i++) {
            table[i] += table[i - safety];
        }
        for (i = fieldGoal; i <= score; i++) {
            table[i] += table[i - fieldGoal];
        }
        for (i = touchDown; i <= score; i++) {
            table[i] += table[i - touchDown];
        }
        for (i = touchDownWithExtra; i <= score; i++) {
            table[i] += table[i - touchDownWithExtra];
        }
        return table[score];
    }
}
