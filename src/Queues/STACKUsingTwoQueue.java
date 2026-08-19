package Queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class STACKUsingTwoQueue {
    public static void main(String[] args) {

    }
    static class Stack{

        Queue<Integer> main = new ArrayDeque<>();
        Queue<Integer> help = new ArrayDeque<>();

        public boolean isEmpty(){
            return main.isEmpty() && help.isEmpty();
        }

        public void add(int val){
                if(!main.isEmpty()){
                    main.add(val);
                }else {
                    help.add(val);
                }
        }

        public int pop(){
            if(isEmpty()){
                System.out.println("Empty stack!!!");
                return -1;
            }
            int top = -1;

            if(!main.isEmpty()) {
                while (!main.isEmpty()) {
                    top  = main.remove();
                    if(main.isEmpty()){
                        break;
                    }
                    help.add(top);
                }
            }else {
                while (!help.isEmpty()){
                    top = help.remove();
                    if(help.isEmpty()){
                        break;
                    }
                    main.add(top);
                }
            }

            return top;

        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Empty stack!!!");
                return -1;
            }
            int top = -1;

            if(!main.isEmpty()) {
                while (!main.isEmpty()) {
                    top  = main.remove();
                    help.add(top);
                }
            }else {
                while (!help.isEmpty()){
                    top = help.remove();

                    main.add(top);
                }
            }

            return top;

        }
    }

}
