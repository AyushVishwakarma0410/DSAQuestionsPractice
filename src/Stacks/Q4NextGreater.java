package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class Q4NextGreater {
    public static void main(String[] args) {
        int [] arr = {6,8,0,1,3};

        System.out.println(Arrays.toString(nextGreater(arr)));
    }

    // next greater
    // next smallest
    // prev greater
    // prev smallest
    // all these questions can be done
    public static int [] nextGreater(int [] arr){

        int [] ans = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length-1; i >= 0; i--) {

        // store index not value
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                    stack.pop();
            }

            // if else
            if(stack.isEmpty()){
                ans[i] = -1;
            }
            else {
                ans[i] =arr[stack.peek()];

            }

        stack.push(i);
        }

        return ans;
    }
}
