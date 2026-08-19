package Recursion;

import java.util.LinkedList;

public class ReverseLL {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {


    }

    public static ListNode reverse(ListNode head){
            if(head == null || head.next == null){
                return head;
            }

            ListNode newHead = reverse(head.next);

            head.next.next = head;

            head.next = null;

        return newHead;
    }
}
