package edu.problems.interviews.bloomberg.z_outside_course;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

    private final Map<Integer, CheckIn> checkInMap;
    private final Map<String, Journey> journeyMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        journeyMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id,new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkInMap.remove(id);
        String routeKey = checkIn.stationName +"->"+stationName;
        Journey journey = journeyMap.getOrDefault(routeKey, new Journey(0, 0));
        journey.addTrip(t - checkIn.time);
        journeyMap.put(routeKey, journey);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation+"->"+endStation;
        return journeyMap.get(routeKey).getAverageTime();
    }

    private class CheckIn {
        String stationName;
        int time;

        CheckIn(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    private class Journey {
        double totalTravelTime;
        int trips;

        Journey(double totalTravelTime, int trips){
            this.totalTravelTime = totalTravelTime;
            this.trips = trips;
        }

        void addTrip(int time){
            totalTravelTime+=time;
            trips++;
        }

        public double getAverageTime(){
            return totalTravelTime / trips;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
