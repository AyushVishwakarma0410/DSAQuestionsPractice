package Queues.Deques;

import java.util.LinkedList;
import java.util.Queue;

public class LC225 {
    public static void main(String[] args) {
            MyStack stack = new MyStack();
            stack.push(1);
            stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
    }
        static class MyStack {

            Queue<Integer> q = new LinkedList<>();
            Queue<Integer> help = new LinkedList<>();

            public MyStack() {
            }

            public void push(int x) {
                q.add(x);
            }

            public int pop() {
                if(empty()){
                    return -1;
                }
                while (q.size() != 1){
                    help.add(q.remove());
                }

                int res = q.remove();
                while (!help.isEmpty()){
                    q.add(help.remove());
                }
                return res;
            }

            public int top() {
                if(q.isEmpty()){
                    return -1;
                }

                while (q.size() != 1){
                    help.add(q.remove());
                }

                int res = q.peek();

                help.add(q.remove());

                while (!help.isEmpty()){
                    q.add(help.remove());
                }
                return res;
            }

            public boolean empty() {
                return q.isEmpty();
            }
        }

}
