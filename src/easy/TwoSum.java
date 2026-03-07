package easy;

import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // Ikkita sikl bilan har bir kombinatsiyani tekshirib chiqamiz
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // Agar yig'indi targetga teng bo'lsa, indekslarni qaytaramiz
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        // Agar topilmasa bo'sh massiv
        return new int[] {};
    }

    // Oddiy test qilish uchun main metod
    public static void main(String[] args) {
        TwoSum solver = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solver.twoSum(nums, target);

        // Natijani konsolga chiqarish
        System.out.println("Natija: " + Arrays.toString(result));
    }
}
