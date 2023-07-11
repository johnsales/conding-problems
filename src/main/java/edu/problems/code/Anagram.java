package edu.problems.code;

import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        char str1[] = { 't', 'e', 's', 't' };
        char str2[] = { 't', 't', 'e', 'w' };
        List<String> list = new ArrayList<>(Arrays.asList("Carro","Arroc","Maria","Marai","Riama","Joao","Oajo","Port","Torp"));

        if (areAnagram(str1, str2))
            System.out.println("The two strings are anagram of each other");
        else
            System.out.println("The two strings are not anagram of each other");

        System.out.println("Anagram List using Hashtable");
        System.out.println(areAnagramHashMap("ABC","CBA"));

        System.out.println("Group of Anagrams");
        System.out.println(groupAnagrams(new String[]{"Carro","Arroc","Maria","Marai","Riama","Joao","Oajo","Port","Torp"}));

    }

    /* function to check whether two strings are anagram of each other */
    static boolean areAnagram(char[] str1, char[] str2) {
        // Get lenghts of both strings
        int n1 = str1.length;
        int n2 = str2.length;

        // If length of both strings is not same, then they cannot be anagram
        if (n1 != n2)
            return false;

        // Sort both strings
        Arrays.sort(str1);
        Arrays.sort(str2);

        // Compare sorted strings
        for (int i = 0; i < n1; i++)
            if (str1[i] != str2[i])
                return false;
        return true;
    }

    /* function to check whether two strings are anagram of each other */
    static boolean areAnagramHashMap(String str1, String str2) {
        // If length of both strings is not same, then they cannot be anagram
        if (str1.length() != str2.length())
            return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            map1.put(str1.charAt(i), 1);
            map2.put(str2.charAt(i), 1);
        }

        // Compare sorted strings
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if(!entry.getValue().equals(map2.get(entry.getKey()))) return false;
        }
        return true;
    }

    static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(str);
        }
        return new ArrayList<>(map.values());
    }


}
