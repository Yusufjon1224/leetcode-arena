package easy;

public class PalindromeNumber {

    public static class Solution {
        public boolean isPalindrome(int x) {
            // Manfiy sonlar palindrome bo'la olmaydi (masalan, -121 != 121-)
            // Shuningdek, 0 bilan tugaydigan sonlar (0 ning o'zi mustasno) palindrome emas
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }

            int reversedNumber = 0;
            int original = x;

            while (x > 0) {
                int lastDigit = x % 10;
                reversedNumber = reversedNumber * 10 + lastDigit;
                x = x / 10;
            }

            // Teskari o'girilgan son asl nusxasiga teng bo'lsa - palindrome
            return original == reversedNumber;
        }
    }

    // GitHub uchun test holatlari
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: Oddiy palindrome
        int test1 = 121;
        System.out.println("Test 1 (121): " + sol.isPalindrome(test1)); // true

        // Test 2: Manfiy son
        int test2 = -121;
        System.out.println("Test 2 (-121): " + sol.isPalindrome(test2)); // false

        // Test 3: 10 bilan tugaydigan son
        int test3 = 10;
        System.out.println("Test 3 (10): " + sol.isPalindrome(test3)); // false

        // Test 4: Bir xonali son
        int test4 = 7;
        System.out.println("Test 4 (7): " + sol.isPalindrome(test4)); // true
    }
}
