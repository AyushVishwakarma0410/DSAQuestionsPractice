package Queues;

import java.util.Stack;

public class LC232 {
    public static void main(String[] args) {

        MyQueue queue = new MyQueue();
//        queue.push(1);
//        queue.push(2);
        System.out.println(queue.pop());
    }
    static class MyQueue {

        Stack<Integer> main = new Stack<>();
        Stack<Integer> help = new Stack<>();

        public MyQueue() {
        }




        public void push(int x) {

            main.push(x);

        }

        public int pop() {

            if(empty()){
                return -1;
            }

            if(help.isEmpty()){
                while (!main.isEmpty()){
                    help.push(main.pop());
                }
            }
            return help.pop();


        }

        public int peek() {

            if (empty()){
                return -1;
            }
            if(help.isEmpty()){
                while (!main.isEmpty()){
                    help.push(main.pop());
                }
            }

            return help.peek();
        }

        public boolean empty() {

            return help.isEmpty() && main.isEmpty();

        }
    }
}
