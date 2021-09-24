package edu.problems.code;

public class BeautifulString {
    public static void main(String[] args) {
        BeautifulString beautifulString = new BeautifulString();
        System.out.println(beautifulString.isBeautifulString("dcbaee"));

        Thread t;
    }

    boolean isBeautifulString(String string){
        int[] array = new int[26];

        //fulfill the array 97 ascii code == a
        for (int i = 0; i < string.length(); i++) {
            array[string.toLowerCase().charAt(i) - 97]++;
        }

        //check validation with only the filled
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] < array[i+1]) return false;
        }
        return true;
    }
}
