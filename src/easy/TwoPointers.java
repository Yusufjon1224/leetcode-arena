package easy;

import java.util.Arrays;

public class TwoPointers {

    public static class Solution {
        public int[] moveZeroes(int[] nums) {
            // 1. Noldan farqli elementlarni oldinga yig'amiz
            int lastNonZeroIndex = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[lastNonZeroIndex] = nums[i];
                    lastNonZeroIndex++;
                }
            }

            // 2. Qolgan bo'sh joylarni nollar bilan to'ldiramiz
            for (int i = lastNonZeroIndex; i < nums.length; i++) {
                nums[i] = 0;
            }

            return nums;
        }
    }

    // Test qismi
    public static void main(String[] args) {
        Solution sol = new Solution();

        // 1-misol: Aralash sonlar
        int[] test1 = {0, 1, 0, 3, 12};
        sol.moveZeroes(test1);
        System.out.println("1-test natijasi: " + Arrays.toString(test1));

        // 2-misol: Faqat bitta nol
        int[] test2 = {0};
        sol.moveZeroes(test2);
        System.out.println("2-test natijasi: " + Arrays.toString(test2));

        // 3-misol: Nollar allaqachon oxirida bo'lsa
        int[] test3 = {4, 5, 0, 0};
        sol.moveZeroes(test3);
        System.out.println("3-test natijasi: " + Arrays.toString(test3));
    }
}