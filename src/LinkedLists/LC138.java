package LinkedLists;

import static LinkedLists.LinkedLists.printLL;

public class LC138 {
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

//        head.next.next.next.next.next = new Node(6);

        head.random = null;
        head.next.random = head;
        head.next.next.random =head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;



        Node l1 = copyRandomList(head);
        printLL(l1);
    }
    public static void printLL(Node head){

        if(head == null){
            System.out.println("No list present");
            return;
        }
        Node temp = head;

        while (temp.next!=null){
            System.out.print(temp.val);
            System.out.print("->");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }




    // self done bitch
    // No gpt needed
    // can be optimized but i dont want to.
    public static Node copyRandomList(Node head) {

        if(head == null){
            return  null;
        }


        // main list
        Node temp = head;

        // copy list
        Node buildList = new Node(-1);

        // iteration
        while (temp!=null){
            buildList =  addLast(temp.val,buildList);
            temp = temp.next;
        }




        temp = head;
        Node temp2 = buildList.next;
        while (temp!=null){
            Node point = temp.random;
            if(point == null){
                temp2.random = null;
                temp = temp.next;
                continue;

            }
            int ranIdx =  find(point,head);
            temp2.random = connect(ranIdx,temp2);
            temp = temp.next;
        }

        return buildList.next;
    }

    public static int find(Node point, Node head){

        int idx = 0;
        while (head != point){
//            System.out.println(head.val);
            head = head.next;
            idx++;
        }

//        System.out.println("loop ends");
        return idx;

    }

    public static Node connect(int idx, Node head){
        int i = 0;
        while (i != idx){
            head = head.next;
            i++;
        }
        return head;
    }


    static class Node{
        int val;
        Node next;
        Node random;
        Node(int val){
            this.val = val;
            Node next = null;
            Node random = null;
        }
    }
    public static Node addLast(int val,Node buildList){


        Node temp = buildList;
        while (buildList.next!=null){
            buildList = buildList.next;
        }

        buildList.next = new Node(val);



        return temp;
    }
}
