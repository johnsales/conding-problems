package edu.problems.cracking_code_interview.chapter1;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StringCompression {
    public static void main(String[] args) {
//        System.out.println(stringCompression("aabcccccaaa"));
        System.out.println(stringCompression("abbbbbc"));
    }

    static String stringCompression(String string){

        StringBuilder compressedString = new StringBuilder();
        int countConsecutively = 0;
        for (int i = 0; i < string.length(); i++) {
            countConsecutively++;
            if(i + 1 >= string.length() || string.charAt(i) != string.charAt(i + 1)){
                compressedString.append(string.charAt(i));
                compressedString.append(countConsecutively);
                countConsecutively = 0;
            }
        }

        return string.length() <= compressedString.length() ? string : compressedString.toString();
    }
}
