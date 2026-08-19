package LinkedLists;

import static LinkedLists.LinkedLists.printLL;

public class LLQ4 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(7);
         head = oddEven(head);
        printLL(head);
    }

    // koshish failed successfully
//    public static Node OddEvn(Node head){
//        Node even = null;
//        Node evenHead = null ;
//        Node odd = null ;
//        Node oddHead = null;
//
//        Node temp = head;
//
//        while (temp!=null){
//            if(temp.value%2==0){
//                if(evenHead==null){
//                    evenHead = even;
//                    even = new Node(temp.value);
//                }else {
//                    even.next = new Node(temp.value);
//                }
//                even = even.next;
//            }else {
//                if(oddHead== null){
//                    oddHead = odd;
//                    odd = new Node(temp.value);
//                }else {
//                    odd.next =  new Node(temp.value);
//                }
//                odd = odd.next;
//            }
//            temp = temp.next;
//        }
//
//
//
//        even.next = oddHead;
//
//
//        return evenHead;
//
//
//    }


    public static Node oddEven(Node head){

        if(head==null) return null;

        Node evenHead = null;
        Node evenTail = null;
        Node oddHead = null;
        Node oddTail = null;

        Node curr = head;

        while (curr!=null){
            Node next = curr.next;
            curr.next = null;

            if(curr.value % 2 == 0){
                if(evenHead == null){
                    evenHead = evenTail = curr;
                }
                else {
                    evenTail.next = curr;
                    evenTail = evenTail.next;
                }
            }else {
                if(oddHead == null){
                    oddHead = oddTail = curr;
                }
                else {
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }

            curr = next;
        }

        if(evenTail!=null){
            evenTail.next = oddHead;
            return evenHead;
        }else {
            return oddHead;
        }
    }
}
