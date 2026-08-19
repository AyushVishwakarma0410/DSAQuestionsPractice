package Stacks;

public class LinkedListImplementation {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    static class Stack {

        private Node head;
        private int size;

        public boolean isEmpty() {
            return head == null;
        }

        public boolean push(int val) {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            size++;
            return true;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack underflow");
                return -1;
            }

            int val = head.val;
            head = head.next;
            size--;
            return val;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack underflow");
                return -1;
            }
            return head.val;
        }

        public int size() {
            return size;
        }
    }
}
