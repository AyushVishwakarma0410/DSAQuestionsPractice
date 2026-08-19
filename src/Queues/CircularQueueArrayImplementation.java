package Queues;

public class CircularQueueArrayImplementation {
    public static void main(String[] args) {

    }


    static class Queue {
        private int[] arr;
        private int size;
        private int front;
        private int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;

        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }



        // add
        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full!!");
                return;
            }
            // add
            if(front == -1){
                front=0;
            }
            rear  = (rear+1) % size;
            arr[rear] = data;

        }

        // remove
        public int remove() {
            if (isEmpty()) {
                System.out.println("Empty Queue!");
                return -1;
            }

            int result = arr[front];
            if(front==rear){
                rear = front = -1;
            }else {
                front = (front+1) % size;
            }
            return result;
        }

        //peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue!!");
                return -1;
            }

            // returning front element
            return arr[front];
        }

    }
}