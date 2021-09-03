package edu.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class TeamFormation {
    public static void main(String[] args) {
        TeamFormation formation = new TeamFormation();
        System.out.println(formation.countTeams(Arrays.asList(12,4,6,13,5,10),3, 4,10));
    }

    public int countTeams(List<Integer> skills, int minPlayers, int minLevel, int maxLevel){
        //combination's formula n! / r! * (n - r)!
        //4,6,5, 10
        int numberMatchedSkills =  (int) skills.stream().filter( value -> value >= minLevel && value <= maxLevel).count();
        int startCombination = minPlayers, result = 0;

        while (startCombination <= numberMatchedSkills){
            result += countCombinations(numberMatchedSkills, startCombination);
            startCombination++;
        }
        return result;
    }

    //combination's formula n! / r! * (n - r)!
    int countCombinations(int n, int r){
        int nFat = (int)LongStream.rangeClosed(1, n).reduce(1, (long x, long y) -> x * y);
        int rFat = (int)LongStream.rangeClosed(1, r).reduce(1, (long x, long y) -> x * y);
        int n_Minus_r_Fat = (int)LongStream.rangeClosed(1, n-r).reduce(1, (long x, long y) -> x * y);
        int result = nFat / (rFat * n_Minus_r_Fat);
        return result;
    }
}
