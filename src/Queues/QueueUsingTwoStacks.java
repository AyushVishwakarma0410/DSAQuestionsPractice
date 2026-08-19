package Queues;

import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {

    }



    // type 1
    static class Queue1{
        Stack<Integer> main = new Stack<>();
        Stack<Integer> help = new Stack<>();

        public boolean isEmpty(){
            return main.isEmpty() && help.isEmpty();
        }


        // costly add
        public void add(int val){
            while (!main.isEmpty()) {
                help.push(main.pop());
            }

                main.push(val);
                while (!help.isEmpty()){
                    main.push(help.pop());
                }

        }


        public int remove(){
            if (main.isEmpty()){
                System.out.println("Queue is empty!!");
                return -1;
            }
            return main.pop();

        }

        public int peek(){
            if (main.isEmpty()) {
                System.out.println("Queue is empty!!");
                return -1;
            }
            return main.peek();
        }


    }



    // type 2
    static class Queue2 {
        Stack<Integer> main = new Stack<>();
        Stack<Integer> help = new Stack<>();

        public boolean isEmpty() {
            return main.isEmpty() && help.isEmpty();
        }

        public void add(int val) {
            main.push(val);
        }

        public int remove() {

            if(isEmpty()){
                System.out.println("Queue is empty!!");
                return -1;
            }
            while (!main.isEmpty()) {
                help.push(main.pop());
            }

            int val = help.pop();

            while (!help.isEmpty()) {
                main.push(help.pop());
            }

            return val;
        }

        public int peek() {

            if(isEmpty()){
                System.out.println("Queue is Empty!!");
                return -1;
            }

            while (!main.isEmpty()) {
                help.push(main.pop());
            }

            int val = help.peek();

            while (!help.isEmpty()) {
                main.push(help.pop());
            }

            return val;
        }
    }

    // type 3
    // same as type 2 but improved
    static class Queue3 {
        Stack<Integer> main = new Stack<>();
        Stack<Integer> help = new Stack<>();

        public boolean isEmpty() {
            return main.isEmpty() && help.isEmpty();
        }

        public void add(int val) {
            main.push(val);
        }

        public int remove() {

            if(isEmpty()){
                System.out.println("Queue is Empty!!");
                return -1;
            }

            if(help.isEmpty()) {
                while (!main.isEmpty()) {
                    help.push(main.pop());
                }
            }

            return help.pop();
        }

        public int peek() {

            if(isEmpty()){
                System.out.println("Queue is Empty!!");
                return -1;
            }

            if(help.isEmpty()) {
                while (!main.isEmpty()) {
                    help.push(main.pop());
                }
            }


            return help.peek();
        }
    }
}
