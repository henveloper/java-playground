package grind75;

// https://leetcode.com/problems/merge-two-sorted-lists/
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

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        ListNode ptr = new ListNode(0);
        ListNode root = ptr;

        // splicing
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val >= ptr2.val) {
                ptr.next = ptr2;
                ptr2 = ptr2.next;
            } else {
                ptr.next = ptr1;
                ptr1 = ptr1.next;
            }
            ptr = ptr.next;
        }

        if (ptr1 != null) {
            ptr.next = ptr1;
        } else {
            ptr.next = ptr2;
        }

        return root.next;
    }
}
