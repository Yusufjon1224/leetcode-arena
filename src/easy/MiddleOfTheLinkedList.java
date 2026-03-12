package easy;

/**
 * Problem: 876. Middle of the Linked List
 * Link: https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfTheLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: [1,2,3,4,5] -> O'rtasi 3
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode mid1 = sol.middleNode(head1);
        System.out.print("Test 1 natijasi: ");
        printList(mid1); // [3, 4, 5]

        // Test 2: [1,2,3,4,5,6] -> O'rtasi 4 (juft bo'lsa o'ngdagisi)
        ListNode head2 = createList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode mid2 = sol.middleNode(head2);
        System.out.print("Test 2 natijasi: ");
        printList(mid2); // [4, 5, 6]
    }

    // Massivdan Linked List yaratish
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Ro'yxatni chop etish
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }

    static class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
