package edu.problems.interviews.bloomberg.z_outside_course;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 Design a Leaderboard class, which has 3 functions:

 1. addScore(playerId, score): Update the leaderboard by adding score to the given player's score.
    If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
 2. top(K): Return the score sum of the top K players.
 3. reset(playerId): Reset the score of the player with the given id to 0 (in other words erase it from the
    leaderboard). It is guaranteed that the player was added to the leaderboard before calling this function.
 */
public class Leaderboard {

    Map<Integer, Integer> map;
    public Leaderboard() {
        map = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId,0)+score);
    }

    public int top(int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        pq.addAll(map.values());
        int topKSum = 0;
        int count = Math.min(map.values().size(), K);
        while(!pq.isEmpty() && --count >= 0){
            topKSum+=pq.poll();
        }
        return topKSum;
    }

    public void reset(int playerId) {
        //verify if the playerId exists
        if(map.containsKey(playerId))
            map.put(playerId,0);
    }
}
