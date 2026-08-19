package LinkedLists;

public class LLQ3 {
    public static void main(String[] args) {


        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(7);
        printLL(head);
        head = SwappingNodes(head,2,4);
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


    public static Node SwappingNodes(Node head,int x,int y){


        if(head== null || x == y){
            return head;
        }


        Node X = head;
        Node Y = head;
        Node X_1 = null;
        Node Y_1 = null;
        int idx = 1;

        while (x!=idx){
            X_1 = X;
            X = X.next;
            idx+=1;
        }

        idx = 1;

        while(y!=idx){
            Y_1 = Y;
            Y = Y.next;
            idx+=1;
        }

        // If either x or y is out of bounds
        if (X == null || Y == null) return head;


        // if X is not head
        if (X_1 != null) {
            X_1.next = Y;
        } else {
            head = Y;
        }

        // If Y is not head
        if (Y_1 != null) {
            Y_1.next = X;
        } else {
            head = X;
        }
        Node temp = X.next;
        X.next = Y.next;
        Y.next = temp;

        return head;
    }
}
