package LinkedLists;

public class LinkedLists2 {
    public static void main(String[] args) {


    }

    // floyd warshall algorithm
    public static boolean detectCycle(Node head){

        if(head==null){
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }


        }

        return false;

    }


    // rewatch video important
    public static Node removeCycle(Node head){
        if(head==null){
            return null;
        }
        boolean hasLoop = false;

        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                hasLoop = true;
                break;
            }
        }
        if (!hasLoop) {
            return head;   // No cycle
        }

        slow = head;

        // special case
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
            return head;
        }



            Node prev = null;
            while (slow!=fast){
                slow = slow.next;
                prev = fast;
                fast = fast.next;
            }
            prev.next = null;

        return head;

    }

}
