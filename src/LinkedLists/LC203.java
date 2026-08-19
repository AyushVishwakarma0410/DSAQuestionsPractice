package LinkedLists;

public class LC203 {

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

    public static void main(String[] args) {
            Node head = new Node(7);
            head.next = new Node(7);
            head.next.next = new Node(7);
            head.next.next.next = new Node(7);

             head = removeElements(head,7);
             printLL(head);
    }
    public static Node removeElements(Node head, int val) {

        if(head==null){
            return head;
        }


        // 1
        while (head!=null && head.value==val){
            head=head.next;
        }

        // 2
        Node temp;
        if(head==null || head.next==null)
            return head;
        else temp = head.next;


        Node curr = head;

        while (temp!=null){

            while (temp.value==val){
                temp= temp.next;
                if(temp==null){
                    curr.next = temp;
                    return head;
                }
            }

            curr.next = temp;
            curr = temp;
            temp= temp.next;

        }
        return head;
    }
}
