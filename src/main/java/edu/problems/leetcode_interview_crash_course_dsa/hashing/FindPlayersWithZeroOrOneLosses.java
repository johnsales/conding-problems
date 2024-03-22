package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.*;

/**
 You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri
 defeated player loseri in a match.

 Return a list answer of size 2 where:

 answer[0] is a list of all players that have not lost any matches.
 answer[1] is a list of all players that have lost exactly one match.
 The values in the two lists should be returned in increasing order.

 Note:

 You should only consider the players that have played at least one match.
 The testcases will be generated such that no two matches will have the same outcome.
 */
public class FindPlayersWithZeroOrOneLosses {

    //O(n⋅logn) and O(n)
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> loosesMap = new HashMap<>();

        for(int[] match : matches){
            int winner = match [0], looser = match [1];
            loosesMap.put(winner,loosesMap.getOrDefault(winner, 0));
            loosesMap.put(looser,loosesMap.getOrDefault(looser, 0) + 1);
        }

        List<List<Integer>> answer = Arrays.asList(new ArrayList(),new ArrayList());
        for(int key : loosesMap.keySet()){
            if(loosesMap.get(key) == 0){
                answer.get(0).add(key);
            }else if(loosesMap.get(key) == 1){
                answer.get(1).add(key);
            }
        }

        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));

        return answer;
    }
}
