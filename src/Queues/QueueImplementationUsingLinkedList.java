package Queues;

public class QueueImplementationUsingLinkedList {
    public static void main(String[] args) {

    }

    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    static class Queue{

        private Node head;
        private Node tail;


        // Empty
        public boolean isEmpty(){
            return head == null && tail==null;
        }



        // add
        public void add(int val){
            Node newNode = new Node(val);
            if(head==null){
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        // remove
        public int remove(){
            if(isEmpty()){
                System.out.println("Empty!");
                return -1;
            }
            int front = head.val;

            if(tail==head){
                tail = head = null;
            }else {
                head = head.next;
            }
            return front;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue!");
                return -1;
            }

            return head.val;
        }


    }
}
