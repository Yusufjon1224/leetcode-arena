package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: 3. Longest Substring Without Repeating Characters
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring {

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test keyslari
        String[] tests = {"abcabcbb", "bbbbb", "pwwkew", ""};
        int[] expected = {3, 1, 3, 0};

        System.out.println("--- Longest Substring Test Results ---");

        for (int i = 0; i < tests.length; i++) {
            int result = sol.lengthOfLongestSubstring(tests[i]);
            System.out.printf("Input: \"%s\" | Expected: %d | Result: %d | %s\n",
                    tests[i], expected[i], result,
                    (result == expected[i] ? "✅" : "❌"));
        }
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int left = 0, maxLength = 0;
            Set<Character> seenChars = new HashSet<>();

            for (int right = 0; right < s.length(); right++) {
                char currentChar = s.charAt(right);

                // Takrorlanish bo'lsa, oyna chapini qisqartiramiz
                while (seenChars.contains(currentChar)) {
                    seenChars.remove(s.charAt(left));
                    left++;
                }

                seenChars.add(currentChar);
                maxLength = Math.max(maxLength, right - left + 1);
            }
            return maxLength;
        }
    }
}