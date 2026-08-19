package Stacks;

public class ArrayImplementation {

    static class stack{

         private int [] arr ;
         private int top;

        stack(int n){
            arr = new int[n];
            top = -1;
        }





        public boolean isEmpty(){
            return top == -1;
        }

        public boolean push(int num){

            if(top == arr.length-1){
                System.out.println("stack overflow"); return false;
            }
            top++;
            arr[top] = num;
            return true;
        }

        public  int pop(){
            if(isEmpty()){
                System.out.println("Stack Underflow!!");
                return -1;
            }

            int popped = arr[top];
            top--;
            return popped;
        }

        public  int peek(){
            if(isEmpty()){
                System.out.println("stack is empty");
                return -1;
            }
            return arr[top];
        }

        public  int size(){
            return top + 1 ;
        }


    }

    public static void main(String[] args) {
            stack s = new stack(5);
            System.out.println(s.size());
    }
}
