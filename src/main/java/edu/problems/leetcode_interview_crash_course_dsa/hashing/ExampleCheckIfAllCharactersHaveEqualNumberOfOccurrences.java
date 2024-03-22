package edu.problems.leetcode_interview_crash_course_dsa.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 Example 3: 1941. Check if All Characters Have Equal Number of Occurrences

 Given a string s, determine if all characters have the same frequency.

 For example, given s = "abacbc", return true. All characters appear twice. Given s = "aaabb", return false. "a"
 appears 3 times, "b" appears 2 times. 3 != 2.
 */
public class ExampleCheckIfAllCharactersHaveEqualNumberOfOccurrences {
    class Solution {
        public boolean areOccurrencesEqual(String s) {
            Map<Character, Integer> counts = new HashMap<>();
            for (char c: s.toCharArray()) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }

            Set<Integer> frequencies = new HashSet<>(counts.values());
            return frequencies.size() == 1;
        }
    }
}
