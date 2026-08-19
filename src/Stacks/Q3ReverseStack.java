package Stacks;

import java.util.Stack;

public class Q3ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        rev(stack);
        System.out.println(stack);
    }

    // such a ridiculous method

    public static void rev(Stack<Integer> stack){

        if(stack.isEmpty()){
            return;
        }

        int num = stack.pop();
        rev(stack);
        pushAtBottom(stack,num);


    }

    //push at bottom

    public static void pushAtBottom(Stack<Integer> stack,int val){

        if(stack.isEmpty()){
            stack.push(val);
            return;
        }

        int num = stack.pop();
        pushAtBottom(stack,val);
        stack.push(num);
    }
}
