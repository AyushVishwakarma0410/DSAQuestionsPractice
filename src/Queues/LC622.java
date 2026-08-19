package Queues;

import java.util.LinkedList;
// 100 % self done
public class LC622 {
    public static void main(String[] args) {

        MyCircularQueue q  = new MyCircularQueue(3);
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        System.out.println(q.Rear());
        System.out.println(q.isFull());
        System.out.println(q.deQueue());
        q.enQueue(4);
        System.out.println(q.Rear());

    }

    static class Node {
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }


    static   class MyCircularQueue {


         Node head = null;
         Node tail = null;
        int size = 0;
        int targetSize = 0;

        public MyCircularQueue(int k) {
            size = k;
        }

        public boolean enQueue(int value) {


            if(targetSize==size){
//                System.out.println("False");
                return false;

            }

            Node newNode = new Node(value);

            if(head==null){
                head = newNode;
                tail = newNode;
                newNode.next = head;
            }else {
                newNode.next = head;
                tail.next = newNode;
                tail = tail.next;
//                System.out.println("True");
             }
            targetSize++;
            return true;

        }

        public boolean deQueue() {

            if(targetSize==0){
//                System.out.println("False");
                return false;

            }
            if(head==tail){
                head = null;
                tail = null;
//                System.out.println("True");
                return true;
            }
            else {
                tail.next = head.next;
                head = head.next;

            }


            targetSize--;
//            System.out.println("True");
            return true;
        }

        public int Front() {

            if(head == null){
                return -1;
            }

            return head.val;

        }

        public int Rear() {

            if(head == null){
                return -1;
            }

            return tail.val;


        }

        public boolean isEmpty() {
//            System.out.println(head==null);
            return head==null;
        }

        public boolean isFull() {
            return size==targetSize;
        }
    }




}
