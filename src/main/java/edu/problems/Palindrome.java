package edu.problems;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.getSubStringPalindromes("elee"));
    }

    //simple
    boolean isPalindrome(String string){
        StringBuilder builder = new StringBuilder(string);
        return builder.toString().equals(builder.reverse().toString());
    }

    //sub string
    List getSubStringPalindromes(String string){
        StringBuilder builder = new StringBuilder();
        List<String> subStringPalindromes = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            if(builder.length() > 2 && builder.toString().equals(builder.reverse().toString()))
                subStringPalindromes.add(builder.toString());

            builder.append(string.charAt(i));
        }

        return subStringPalindromes;
    }
}
