package Stacks;
import java.util.Stack;

public class Q1PushAtBottomOfStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);

        pushAtBottom(stack,4);


        System.out.println(stack);
    }

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
