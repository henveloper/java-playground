package grind75;

/*
 * Link: https://leetcode.com/problems/palindrome-linked-list/submissions/
 * Explaination: reverse last half list then 2 ptrs
 * Optimality: linear time and const space
 */
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
    public boolean isPalindrome(ListNode head) {
        // locate mid pt, take latter for 2n
        ListNode slow = head;
        ListNode fast = head;
        ListNode end = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            end = fast;
            fast = fast.next;
            if (fast != null) {
                end = fast;
            }
        }
        ListNode start = slow;

        // reverse the linked list (start, end)
        // length >= 1
        ListNode curr = start;
        ListNode next = start.next;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = curr;
            curr = next;
            next = tmp;
        }
        start.next = null;

        // list comparison using endIterator as while condition, 
        // since start list on 2k will be longer then end list 
        ListNode endIterator = end;
        ListNode startIterator = head;

        while (endIterator != null) {
            if (endIterator.val != startIterator.val) {
                return false;
            }
            endIterator = endIterator.next;
            startIterator = startIterator.next;
        }

        return true;
    }
}