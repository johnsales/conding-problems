package edu.problems.interviews.bloomberg.z_outside_course;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BrowserHistory {

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com"); // Visits google.com
        browserHistory.visit("facebook.com"); // Visits facebook.com
        browserHistory.visit("youtube.com"); // Visits youtube.com
        System.out.println(browserHistory.back(1)); // Returns "facebook.com"
        System.out.println(browserHistory.back(1)); // Returns "google.com"
        System.out.println(browserHistory.forward(1)); // Returns "facebook.com"
        browserHistory.visit("linkedin.com"); // Visits linkedin.com, forward history is cleared
        System.out.println(browserHistory.forward(2)); // Cannot move forward, returns "linkedin.com"
        System.out.println(browserHistory.back(2)); // Returns "google.com"
        System.out.println(browserHistory.back(7)); // Returns "leetcode.com", cannot move back further
        Random random = new Random();
        System.out.println(random.nextInt(10));
    }

    private List<String> history;
    private int current;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        current = 0;
    }

    public void visit(String url) {
        history.subList(++current, history.size()).clear();
        history.add(url);
    }

    public String back(int steps) {
        current = Math.max(0, current - steps);
        return history.get(current);
    }

    public String forward(int steps) {
        current = Math.min(history.size() -1, current + steps);
        return history.get(current);
    }
}
