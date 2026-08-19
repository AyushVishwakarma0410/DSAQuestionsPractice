package Queues;

public class LC622_2 {
    public static void main(String[] args) {

    }
    static class MyCircularQueue{

        int [] arr;
        int front = 0;
        int rear;
        int size ;


        MyCircularQueue(int size){
            this.size = size;
            arr = new int[size];
            rear = -1;
            front = -1;
        }

        public boolean enQueue(int value){
            if(isFull()){
                return false;
            }
            if(front==-1){
                front=0;
            }
            rear = (rear+1) % size;
            arr[rear] = value;
            return true;
        }


        public boolean deQueue() {
            if(isEmpty()){
                return false;
            }

            if(front==rear){
                rear = -1;
                front = -1;
            }
            else {
                front = (front+1) % size;
            }
            return true;
        }

        public int Front() {
            if(isEmpty()){
                return -1;
            }

            return arr[front];
        }

        public int Rear() {
            if(isEmpty()){
                return -1;
            }
            return arr[rear];
        }

        public boolean isEmpty() {
            return rear== -1 && front == -1;
        }

        public boolean isFull() {
            return (rear+1) % size == front;
        }

    }
}
