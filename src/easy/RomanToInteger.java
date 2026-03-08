package easy;

import java.util.Arrays;

/**
 * Problem: Roman to Integer
 * Link: https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test keyslari
        String[] testInputs = {"III", "LVIII", "MCMXCIV", "IV", "IX"};
        int[] expectedOutputs = {3, 58, 1994, 4, 9};

        System.out.println("--- Roman to Integer Test Results ---");

        for (int i = 0; i < testInputs.length; i++) {
            int result = sol.romanToInt(testInputs[i]);
            System.out.printf("Input: %s | Expected: %d | Result: %d | Status: %s\n",
                    testInputs[i], expectedOutputs[i], result,
                    (result == expectedOutputs[i] ? "PASSED ✅" : "FAILED ❌"));
        }
    }

    public static class Solution {
        public int romanToInt(String s) {
            int result = 0;
            int prevValue = 0;

            // Satrni oxiridan boshlab o'qish eng samarali usul
            for (int i = s.length() - 1; i >= 0; i--) {
                int currentValue = getVal(s.charAt(i));

                // Agar joriy qiymat o'ngdagisidan kichik bo'lsa, ayiramiz (masalan: IV -> 5-1=4)
                if (currentValue < prevValue) {
                    result -= currentValue;
                } else {
                    result += currentValue;
                }
                prevValue = currentValue;
            }

            return result;
        }

        private int getVal(char c) {
            switch (c) {
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
                default: return 0;
            }
        }
    }
}
