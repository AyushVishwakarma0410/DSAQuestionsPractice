package Stacks;

import java.util.Stack;

public class Q2ReverseAString {
    public static void main(String[] args) {
        String s = "abc";
        String t = reverse(s);
        System.out.println(t);
    }

    public static String reverse(String s){

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();

    }
}
