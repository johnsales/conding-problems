package edu.problems.code;

public class SprintTraining {

    public static void main(String[] args) {
        SprintTraining training = new SprintTraining();
        System.out.println(training.GetMostVisited(5, new int[]{2,4,1,3}));
    }

    public int GetMostVisited(int markerCount, int[] sprints) {
        int[] arrayCounter = new int[markerCount+1];
        int mostVisitedNumber = 0;

        //validate markerCount
        for (int i = 0; i < sprints.length; i++)
            if(sprints[i] > markerCount) throw new IllegalArgumentException("Invalid input array");

        for (int i = 0; i < sprints.length-1; i++) {
            int from = Math.min(sprints[i], sprints[i+1]);
            int to = Math.max(sprints[i], sprints[i+1]);

            for (int j = from; j <= to; j++) {
                arrayCounter[j]++;
            }
        }

        for (int i = 0; i < arrayCounter.length; i++) {
            if(arrayCounter[i] > arrayCounter[mostVisitedNumber]) mostVisitedNumber = i;
        }

        return mostVisitedNumber;
    }
}
