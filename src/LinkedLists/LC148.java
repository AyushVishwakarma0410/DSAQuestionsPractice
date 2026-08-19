package LinkedLists;

import static LinkedLists.LinkedLists.printLL;

public class LC148 {
    public static void main(String[] args) {
//        Node head = null;
        Node head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(11);
        head.next.next.next.next.next = new Node(2);



         head = sortList(head);


        printLL(head);
    }

    public static int calSize(Node head){

        int size = 0;

        while (head!=null){
            size++;
            head =head.next;
        }

        return size;

    }





    public static Node sortList(Node head) {



        if(head==null || head.next==null){
            return head;
        }

        int size = calSize(head);

        int mid = size/2;

        // disjoint
        Node temp = head;
        int i = 1;
        while (i < mid){
            temp = temp.next;
            i++;
        }

        Node head2 = temp.next;
        temp.next = null;

        Node l1 = sortList(head);
        Node l2 = sortList(head2);

        return merge(l1,l2);

    }

    public static Node merge(Node head1, Node head2){

        Node head = new Node(-1);
        Node temp = head;
        while (head1!=null && head2!=null){

            if(head1.value <= head2.value){
                head.next = head1;
                head1 = head1.next;
            }

            else {
                head.next = head2;
                head2 = head2.next;
            }

            head = head.next;

        }

        if(head1!=null){
            head.next = head1;
        }
        if(head2!=null){
            head.next = head2;
        }

        return temp.next;
    }
}
