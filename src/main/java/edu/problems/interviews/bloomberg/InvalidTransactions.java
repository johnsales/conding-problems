package edu.problems.interviews.bloomberg;

import java.util.*;

public class InvalidTransactions {
    public static void main(String[] args) {
        InvalidTransactions clazz = new InvalidTransactions();

        String[] transactions1 = {"alice,20,800,mtv", "alice,50,100,beijing"};
        String[] transactions2 = {"alice,20,800,mtv", "alice,50,1200,mtv"};
        String[] transactions3 = {"alice,20,800,mtv", "bob,50,1200,mtv"};

        clazz.invalidTransactions(transactions1).forEach(System.out::println);
        clazz.invalidTransactions(transactions2).forEach(System.out::println);
        clazz.invalidTransactions(transactions3).forEach(System.out::println);
    }

    //O(n²) time complexity & space complexity is O(n)
    public static List<String> invalidTransactions(String[] transactions) {
        List<String> invalidTransactions = new ArrayList<>();

        for (int i = 0; i < transactions.length; i++) {
            String[] parts = transactions[i].split(",");
            String name = parts[0];
            int time = Integer.parseInt(parts[1]);
            int amount = Integer.parseInt(parts[2]);
            String city = parts[3];

            if (amount > 1000) {
                invalidTransactions.add(transactions[i]);
                continue;
            }

            for (int j = 0; j < transactions.length; j++) {
                if (i != j) {
                    String[] otherParts = transactions[j].split(",");
                    String otherName = otherParts[0];
                    int otherTime = Integer.parseInt(otherParts[1]);
                    String otherCity = otherParts[3];

                    if (name.equals(otherName) && !city.equals(otherCity) && Math.abs(time - otherTime) <= 60) {
                        invalidTransactions.add(transactions[i]);
                        break;
                    }
                }
            }
        }
        return invalidTransactions;
    }

    //O(n)
    public List<String> invalidTransactions2(String[] transactions) {
        Map<String, List<Transaction>> transactionMap = new HashMap<>();
        List<String> invalidTransactions = new ArrayList<>();

        // Step 1: Build the map
        for (String trans : transactions) {
            Transaction t = new Transaction(trans);
            transactionMap.putIfAbsent(t.name, new ArrayList<>());
            transactionMap.get(t.name).add(t);
        }

        // Step 2: Check each transaction
        for (String trans : transactions) {
            Transaction t = new Transaction(trans);
            if (t.amount > 1000) {
                invalidTransactions.add(trans);
                continue;
            }

            for (Transaction other : transactionMap.get(t.name)) {
                if (!other.city.equals(t.city) && Math.abs(other.time - t.time) <= 60) {
                    invalidTransactions.add(trans);
                    break;
                }
            }
        }
        return invalidTransactions;
    }

    class Transaction {
        String name;
        int time;
        int amount;
        String city;

        public Transaction(String transactionString) {
            String[] parts = transactionString.split(",");
            this.name = parts[0];
            this.time = Integer.parseInt(parts[1]);
            this.amount = Integer.parseInt(parts[2]);
            this.city = parts[3];
        }
    }
}
