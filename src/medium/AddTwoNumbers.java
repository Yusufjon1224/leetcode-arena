package medium;

/**
 * Problem: 2. Add Two Numbers
 * Link: https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    // Linked List tuguni uchun klass
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: [2,4,3] + [5,6,4] = [7,0,8]
        ListNode l1 = createList(new int[]{2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});
        printList(sol.addTwoNumbers(l1, l2));

        // Test 2: [9,9,9] + [1] = [0,0,0,1]
        ListNode l3 = createList(new int[]{9, 9, 9});
        ListNode l4 = createList(new int[]{1});
        printList(sol.addTwoNumbers(l3, l4));
    }

    // Massivdan Linked List yaratish uchun yordamchi metod
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int x : arr) {
            curr.next = new ListNode(x);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Natijani chiroyli chiqarish uchun
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode curr = dummyHead;
            int carry = 0;

            while (l1 != null || l2 != null || carry != 0) {
                int x = (l1 != null) ? l1.val : 0;
                int y = (l2 != null) ? l2.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            return dummyHead.next;
        }
    }
}