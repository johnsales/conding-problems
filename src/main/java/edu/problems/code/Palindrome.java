package edu.problems.code;

import java.util.HashSet;
import java.util.Set;

/**
  A palindrome is a word, number, phrase, or other sequence of characters which reads the same backward as forward,
  such as madam or racecar. There are also numeric palindromes,
  including date/time stamps using short digits 11/11/11 11:11 and long digits 02/02/2020.
 */
public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.findAllPalindromesUsingBruteForceApproach("abaece"));
        System.out.println(palindrome.longestPalindrome("abb"));
    }

    //BruteForce Approach
    public Set<String> findAllPalindromesUsingBruteForceApproach(String input) {
        Set<String> palindromes = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String subString = input.substring(i, j);
                if (isPalindrome(subString)) {
                    palindromes.add(subString);
                }
            }
        }
        return palindromes;
    }

    //In the example above, we just compare the substring to its reverse to see if it's a palindrome:
    private boolean isPalindrome(String input) {
        StringBuilder plain = new StringBuilder(input);
        StringBuilder reverse = plain.reverse();
        return (reverse.toString()).equals(input);
    }

    //Centralization Approach
    public Set<String> findAllPalindromesUsingCenter(String input) {
        Set<String> palindromes = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            palindromes.addAll(findPalindromes(input, i, i + 1));
            palindromes.addAll(findPalindromes(input, i, i));
        }
        return palindromes;
    }
    //Within the loop above, we expand in both directions to get the set of all palindromes centered at each position.
    //We'll find both even and odd length palindromes by calling the method findPalindromes twice in the loop:
    private Set<String> findPalindromes(String input, int low, int high) {
        Set<String> result = new HashSet<>();
        while (low >= 0 && high < input.length() && input.charAt(low) == input.charAt(high)) {
            result.add(input.substring(low, high + 1));
            low--;
            high++;
        }
        return result;
    }

    /*
     * Explanation: Count the number of character pairs using a HashSet and remove them as you count;
     * The Pairs will be placed in the different directions of the possible palindrome.
     * If there exist more characters in the HashSet, these are unique, and you can only put one in the middle.
     * */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int pairCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                pairCounter++;
            } else {
                set.add(s.charAt(i));
            }
        }
        if (!set.isEmpty()) return pairCounter * 2 + 1;
        return pairCounter * 2;
    }

    /**
        A word, phrase, or sequence that reads the same backward as forward, e.g., madam or nurses run.
     */
    public boolean isPalindromeImproved(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
