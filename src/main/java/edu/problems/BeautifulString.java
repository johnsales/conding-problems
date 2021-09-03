package edu.problems;

import java.util.HashMap;
import java.util.Map;

public class BeautifulString {
    public static void main(String[] args) {
        BeautifulString beautifulString = new BeautifulString();
        System.out.println(beautifulString.isBeautifulString("abcd"));
    }

    boolean isBeautifulString(String string){
        int[] array = new int[26];
        int previous = Integer.MAX_VALUE;

        //fulfill the array
        for (int i = 0; i < string.length(); i++) {
            array[string.toLowerCase().charAt(i) - 97]++;
        }

        //check validation with only the filled
        for (int i = 0; i < array.length; i++) {
            if(array[i] > previous) return false;
            //if(array[i] > 0) previous = array[i];
            previous = array[i];
        }
        return true;
    }
}
