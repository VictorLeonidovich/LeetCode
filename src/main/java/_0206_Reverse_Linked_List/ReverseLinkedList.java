package _0206_Reverse_Linked_List;

import java.util.ArrayList;
import java.util.List;

/**
 * @See https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        List<Integer> nodes = new ArrayList<>();
        nodes.add(head.val);
        while (head.next != null) {
            nodes.add(head.next.val);
            head = head.next;
        }
        //System.out.println("nodes=" + nodes);

        ListNode headRet = new ListNode();
        ListNode tempHead = headRet;
        for (int i = nodes.size(); i > 0; i--) {
            tempHead.val = nodes.get(i - 1);
            if (i - 1 > 0) {
                tempHead.next = new ListNode();
                tempHead = tempHead.next;
            }
            //System.out.println("val=" + nodes.get(i-1));
        }
        return headRet;
    }

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
