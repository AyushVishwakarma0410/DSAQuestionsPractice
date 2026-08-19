package LinkedLists;

public class ZigZagForm {
    public static void main(String[] args) {

    }
    public static Node newList(Node head){

        if(head==null || head.next == null){
            return head;
        }

        // 1.


        Node slow = head;
        Node fast = head.next;
        // caution : we start with fast.next because we want mid to be at pos
        // mid - 1 so that we can divide it in half
        // would have made a separate function but nope
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        Node mid = slow;

        // 2.
        Node curr = mid.next;
        mid.next = null;   // IMPORTANT: break the list

        Node prev = null;
        Node next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;
        Node nextLeft = null;
        Node nextRight = null;


        // 3.
        while (left!=null && right != null){
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;

            right = nextRight;
            left = nextLeft;
        }



        return head;
    }

}
