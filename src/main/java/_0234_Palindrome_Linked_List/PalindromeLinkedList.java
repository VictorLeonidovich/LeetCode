package _0234_Palindrome_Linked_List;

import java.util.ArrayList;
import java.util.List;

/**
 * @See https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> nodes = new ArrayList<>();
        nodes.add(head.val);
        while (head.next != null) {
            nodes.add(head.next.val);
            head = head.next;
        }
        //System.out.println("nodes=" + nodes);
        for (int i = 0; i < nodes.size() / 2; i++) {
            if (nodes.get(i) != nodes.get(nodes.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    //Definition for singly-linked list.
    public class ListNode {
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
}
