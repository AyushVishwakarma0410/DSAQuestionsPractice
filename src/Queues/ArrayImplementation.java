package Queues;


// fixed size
// remove operation TC - O(n)
// we can make circular Queue as well
public class ArrayImplementation {


    static class Queue{
        private int [] arr;
        private int size;
        // size of rear will keep on changing - rear means piche, piche se element add honge
        // front means samne, samne se elements hataye jaenge.
        private int rear ;

        Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;

        }

        public boolean isEmpty(){
            return rear == -1;
        }

        // add
        public void add(int data){
            if(rear==size-1){
                System.out.println("Queue is full!!");
                return;
            }
            rear+=1;
            arr[rear] = data;

        }

        // remove
        public int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue!");
                return -1;
            }

            int front  = arr[0];
            // shifting values towards left
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            // returning removed element
            return front;
        }

        //peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue!!");
                return -1;
            }

            // returning front element
            return arr[0];
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
//        q.add(5);

        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }


}
