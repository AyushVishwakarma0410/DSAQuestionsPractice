package LinkedLists;

import static LinkedLists.LinkedLists.printLL;

public class LC86 {
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(2);
//        head.next.next.next.next.next.next = new Node(45);
//        head.next.next.next.next.next.next.next = new Node(7);



        // for this input you will get confused please please read that fucking question again
        // its important
        head = partition(head,2);
        printLL(head);

    }
    // 100 % self done well done you are on fire my boi
    public static Node partition(Node head, int x) {

        Node part1Head = new Node(-1);
        Node part1 = part1Head;
        Node part2Head = new Node(-1);
        Node part2 = part2Head;
        Node temp = head;


        while (temp!=null){

//            if(temp.value <= x){
//
//                part1.next = temp;
//                part1 = part1.next;
//            }else {
//                part2.next = temp;
//                part2 = part2.next;
//            }

            if(temp.value < x){
                part1.next = temp;
                part1 = part1.next;
            }else {
                part2.next = temp;
                part2 = part2.next;
            }

            temp = temp.next;
        }

        part1.next = part2Head.next;
        part2.next = null;
        printLL(part1Head);
        printLL(part2Head);
        return part1Head.next;
    }
}
