package Stacks;

import java.util.ArrayList;

public class ArrayListImplementation {
    public static void main(String[] args) {

    }

    static class stack{

        // two variables
         private ArrayList<Integer> list = new ArrayList<>();




        public boolean isEmpty(){
            return list.isEmpty();
        }

        public boolean push(int val){
            list.add(val);
            return true;
        }

        public int pop(){
            if(isEmpty()){

                System.out.println("Stack underflow!!");
                return -1;
            }

            return list.remove(list.size()-1);
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty!!");
                return -1;
            }
            return list.get(list.size() - 1);
        }



        public int size(){
            return list.size() ;
        }

    }
}
