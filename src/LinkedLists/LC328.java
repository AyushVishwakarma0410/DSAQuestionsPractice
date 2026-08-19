package LinkedLists;

import static LinkedLists.LinkedLists.printLL;

public class LC328 {
    public static void main(String[] args) {


        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);


        head = oddEvenList(head);

        printLL(head);
    }


        // 100 % my code, well done
        // can be optimized do again with optimization
    public static Node oddEvenList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        // final pointer
        Node oddHead = head; // ----> comment after submitting // no use
        Node evenHead = head.next;
        // Travelling pointers
        Node odd = oddHead;
        Node even = evenHead;




        while (odd.next != null || even.next != null) {

            Node ptr1 = odd.next.next;

            if(ptr1==null){
                break;
            }

            odd.next = ptr1;
            odd = ptr1;
            Node ptr2 = even.next.next;



            if(ptr2 == null){
                break;
            }

            even.next = ptr2;

            even = ptr2;

        }

//        if(odd.next !=null){
//            even.next = odd.next;
//        }
        if(even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = null;
        }

            odd.next = evenHead;

        return oddHead;

    }

    // gpt
    /*
    * class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {

            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
    * */
}
