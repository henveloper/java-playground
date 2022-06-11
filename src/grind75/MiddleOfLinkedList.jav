package grind75;

// https://leetcode.com/problems/middle-of-the-linked-list/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// trivial soln
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null // N = 2k, exceeded, slow is second of mid
                && fast.next != null // N = 2k + 1, end of list
        ) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}