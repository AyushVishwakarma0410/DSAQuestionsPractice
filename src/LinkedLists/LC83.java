package LinkedLists;

public class LC83 {
    public static void main(String[] args) {
        Node head = new Node(1);

        head.next = new Node(1);
        head.next.next = new Node(1);
        deleteDuplicates(head);
        printLL(head);


    }
    // Print LinkedList
    public static void printLL(Node head){


        if(head == null){
            System.out.println("No list present");
            return;
        }
        Node temp = head;

        while (temp.next!=null){
            System.out.print(temp.value);
            System.out.print("->");
            temp = temp.next;
        }
        System.out.println(temp.value);
    }



    public static Node deleteDuplicates(Node head) {

        if(head==null || head.next==null){
            return head;
        }

        Node temp = head;
        while (temp != null){

            while (temp.next!=null && temp.next.value == temp.value){
                temp.next = temp.next.next;
            }


            temp = temp.next;



        }


        return head;
    }
}
