package edu.problems.cracking_code_interview.chapter1;

public class IsUnique {
    public static void main(String[] args) {
        System.out.println(isUnique("abcdefghijklmnopqrstuvxz!@#$%^&*()_+"));
    }

    static boolean isUnique(String string){
        if(string.length() > 128){ //total number of ASCII Table
            return false;
        }
        int[] asciiCounter = new int[128];
        for (int i = 0; i < string.length(); i++) {
            int asciiNumber = string.charAt(i);
            if(asciiCounter[asciiNumber] > 0)
                return false;
            asciiCounter[string.charAt(i)] += 1;
        }
        return true;
    }
}
