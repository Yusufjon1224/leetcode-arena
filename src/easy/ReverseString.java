package easy;

import java.util.Arrays;

/**
 * Problem: 344. Reverse String
 * Link: https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        sol.reverseString(s1);
        System.out.println("Test 1: " + Arrays.toString(s1)); // [o, l, l, e, h]

        // Test 2
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        sol.reverseString(s2);
        System.out.println("Test 2: " + Arrays.toString(s2)); // [h, a, n, n, a, H]
    }

    static class Solution {
        public void reverseString(char[] s) {
            int left = 0;
            int right = s.length - 1;

            while (left < right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;

                left++;
                right--;
            }
        }
    }
}
