package LinkedLists;

public class LinkedLists {

    public static Node head = null;


    public static int size(Node head){
        if(head == null){
            System.out.println("Empty");
            return 0;
        }
        int i = 0;
        Node temp = head;

        while (temp != null){
            temp = temp.next;
            i++;
        }

        return i;

    }



    public static int search(Node head,int target){

        if(head == null){
            return -1;
        }
        int pos = 0;
        Node temp = head;
        while (temp!= null){

            if(temp.value == target){
                return pos;
            }
            pos++;
            temp = temp.next;
        }

        return -1;
    }

    // mentos zindagi
    public static void insertFirst(int value){
        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;

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



    public static void insertAtEnd(int value){

        Node newNode = new Node(value);

        if(head == null){
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;

    }

    //insert at a specific position
    // mehhh
    public static void insertAtSpecificPosition(int value, int pos){

        if(pos==0){
            insertFirst(value);
            return;
        }

        Node newNode = new Node(value);

        if(head == null){
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp!=null && pos > 1){
            temp = temp.next;
            pos--;
        }

        if(temp == null){
            System.out.println("Out of bounds!!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;

    }


    public static void removeFirst(){
        if(head == null){
            System.out.println("List Empty!!");
            return;
        }
        head = head.next;
    }
    public static Node removeFirstAltr(Node head){
        if(head == null){
            System.out.println("List Empty!!");
            return null;
        }
        head = head.next;
        return head;
    }

    public static Node removeLast(Node head){

        if(head == null){
            System.out.println("List is Empty");
            return null;
        }
        if(head.next==null){
            return null;
        }

        Node temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }
    public static Node removeAtSpecific(Node head, int pos){

        if(head == null) return null;  // empty list

        // Handle removing head
        if(pos == 0){
            return head.next;  // new head
        }

        Node temp = head;

        // Move to the node just before the one to remove
        while(temp != null && pos > 1){
            temp = temp.next;
            pos--;   // ✅ decrement pos
        }

        // Check if next node exists
        if(temp == null || temp.next == null){
            System.out.println("Position out of bounds");
            return head;
        }

        // Remove the node
        temp.next = temp.next.next;

        return head;
    }
    public static Node findAndRemoveFromEnd(Node head,int pos){
        int size = 1;

        // edge case : 1
        if(head == null){
            System.out.println("List empty");
            return head;
        }
        // edge case : 2
        if(head.next==null && pos > 1){
            System.out.println("Out of bounds");
            return head;
        }

        //itr

        Node temp = head;
        // reach end
        while (temp.next!=null){
            temp = temp.next;
            size++;
        }


        // one more edge case
        // Remove head
        if (pos == size) {
            return head.next;
        }
        //Example:
        //List size = 5
        //Remove 2nd from end → should remove position 4 from start
        //5 - 2 + 1 = 4 ✅



        // gpt related edge case
        if (pos > size || pos <= 0) {
            System.out.println("Out of bounds");
            return head;
        }



        // making from end to start
        pos = size - pos+1;

        temp = head;

        while (temp.next != null && pos > 2){
            temp = temp.next;
            pos--;
        }

        if(temp.next == null ){
            System.out.println("out of bounds!");
            return head;
        }

        temp.next = temp.next.next;

        return head;

    }

    // better version
    //public static Node removeFromEnd(Node head, int pos) {
    //
    //    if (head == null || pos <= 0) return head;
    //
    //    Node fast = head;
    //    Node slow = head;
    //
    //    for (int i = 0; i < pos; i++) {
    //        if (fast == null) return head; // out of bounds
    //        fast = fast.next;
    //    }
    //
    //    if (fast == null) return head.next;
    //
    //    while (fast.next != null) {
    //        fast = fast.next;
    //        slow = slow.next;
    //    }
    //
    //    slow.next = slow.next.next;
    //
    //    return head;
    //}


    public static int searchR(Node head, int target){

        if(head==null){
            return -1;
        }

        return searchRec(head,target,0);
    }

    public static int searchRec(Node head, int target,int i){

        if(head==null){
            return -1;
        }
        if(head.value == target){
            return i;
        }

        return searchRec(head.next,target,i+1);

    }

    // slow fast pointer concept
    public static Node findMid(Node head){

        if(head==null){
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;


    }

    // reverse half LL
    public static boolean isPalindrome(Node head){

        // edge cases
        if(head==null || head.next == null){
            return true;
        }

        // way 1
        // store all elements in an array or arraylist and check if it is a palindrome or not TC - O(n) SC - O(n)

        // way 2
        // 1. middle node
        // 2. reverse 2nd half
        // 3. check if 1st half = 2nd half


        // 1.

        Node Mid = findMid(head);

        // 2.
        Node prev = null;
        Node curr = Mid;
        Node next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;


        //3.
        while (right != null){
            if(right.value != left.value){
                return false;
            }
            right = right.next;
            left = left.next;
        }

        // rework list
        curr = prev;
        prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return true;
    }



    public static Node revLL(Node head){

        Node current = head;
        Node prev = null;
        Node next = null;
            while (current != null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            return prev;
    }
    public static int altrRecSearch(Node head, int target){
        if(head==null){
            return -1;
        }
        if(head.value==target){
            return 0;
        }

        int idx = altrRecSearch(head.next,target);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }


    public static void main(String[] args) {

        // Aam Zindagi
        LinkedLists list = new LinkedLists();
        list.head = new Node(1);
        head.next = new Node(2);

    }


}
