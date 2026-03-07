package easy;

import java.util.Arrays;

public class ReverseList {

    public static class Solution {
        public int[] rotate(int[] nums, int k) {
            int n = nums.length;
            // Agar k massiv uzunligidan katta bo'lsa, qoldig'ini olamiz
            k = k % n;

            if (k == 0) return nums;

            // 1. Hammasini teskari qilish
            reverse(nums, 0, n - 1);

            // 2. Birinchi k elementni teskari qilish
            reverse(nums, 0, k - 1);

            // 3. Qolganini teskari qilish
            reverse(nums, k, n - 1);

            return nums;
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }

    // Test qilish uchun main metod
    public static void main(String[] args) {
        Solution sol = new Solution();

        // 1-misol: Oddiy holat (k = 3)
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        sol.rotate(nums1, k1);
        System.out.println("1-test (k=3): " + Arrays.toString(nums1));

        // 2-misol: Manfiy sonlar bilan (k = 2)
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        sol.rotate(nums2, k2);
        System.out.println("2-test (k=2): " + Arrays.toString(nums2));

        // 3-misol: k massiv uzunligidan katta bo'lgan holat
        int[] nums3 = {1, 2};
        int k3 = 3; // 3 % 2 = 1 qadam suriladi
        sol.rotate(nums3, k3);
        System.out.println("3-test (k=3, len=2): " + Arrays.toString(nums3));
    }
}