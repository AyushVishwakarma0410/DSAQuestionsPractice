package LinkedLists;

import static LinkedLists.LinkedLists.printLL;

public class LC61 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
//        System.out.println(getTail(head));
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
//        head.next.next.next.next.next = new Node(6);


        head =  rotateRight(head, 8);
        printLL(head);
    }
    public static int getTail(Node head){
        int size = 1;
        while (head.next!=null){
            size++;
            head = head.next;
        }
        return size;
    }

    public static Node rotateRight(Node head, int k) {

        if(head==null || head.next == null){
            return head;
        }


        int size = 1;

        Node tail = head;

        while (tail.next!=null){
            size++;
            tail = tail.next;
        }

        tail.next = head;

        k = k % size;

        if(k == 0){
            tail.next = null;
            return head;
        }
        int idx = size - k;

        int i = 0;

        Node temp = head;
        while (i < idx-1){
            temp = temp.next;
            i++;
        }

        head = temp.next;
        temp.next = null;


        return head;

    }
}
