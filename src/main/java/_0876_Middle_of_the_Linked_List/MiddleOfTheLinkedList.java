package _0876_Middle_of_the_Linked_List;

/**
 * @See https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfTheLinkedList {
    private static int count = 1;
    private ListNode result;

    public synchronized ListNode middleNode(ListNode head) {
        count = 1;
        countNumberOfNodes(head);
        //System.out.println("count1=" + count);
        int half = count / 2 + 1;
        //System.out.println("half=" + half);
        count = 1;
        getNodeByIndex(half, head);
        //System.out.println("result=" + result.val);
        return result;
    }

    private synchronized void countNumberOfNodes(ListNode head) {
        if (head.next != null) {
            count++;
            countNumberOfNodes(head.next);
        }
        //System.out.println(head.val);
        //return;
    }

    private synchronized void getNodeByIndex(int half, ListNode head) {
        //System.out.println("count2=" + count);
        if (count == half) {
            result = head;
            //System.out.println("result.val=" + result.val);
            //return;
        } else {
            count++;
            getNodeByIndex(half, head.next);
        }
        //return;
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
