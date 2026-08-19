package LinkedLists;

import static LinkedLists.LinkedLists.printLL;

public class LC24 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head = swapPairs(head);
        printLL(head);
    }
    public static Node swapPairs(Node head) {
        if(head == null || head.next == null) return head;

        Node temp = head;
        Node head2 = temp.next;
        temp.next = head2.next;
        head2.next = temp;
        head = head2;
        Node prev = temp;
        temp = temp.next;
        if(temp==null){
            return head;
        }
        head2 = temp.next;
//        printLL(head);
//        System.out.println(temp.value);
//        System.out.println(head2.value);

        while (temp.next!=null){
            temp.next = head2.next;
            prev.next = head2;
            prev = temp;
            head2.next = temp;
            temp = temp.next;
            if(temp==null){
                return head;
            }
            head2 = temp.next;

        }

        return head;
    }

}
