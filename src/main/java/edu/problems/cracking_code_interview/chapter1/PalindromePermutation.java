package edu.problems.cracking_code_interview.chapter1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("Tact Coa"));
    }

    static boolean isPalindromePermutation(String input){
        Map<Character, Integer> map = new HashMap<>();
        boolean hasUniqueCharacter = false;
        for (int i = 0; i < input.length(); i++)
            if (input.charAt(i) != ' ')
                map.merge(Character.toLowerCase(input.charAt(i)), 1, Integer::sum);

        for (Entry<Character, Integer> entry :map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                if (hasUniqueCharacter) return false;
                else hasUniqueCharacter = true;
            }
        }
        return true;
    }
}
