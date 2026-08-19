package Stacks;

import java.util.Stack;

public class Q5DuplicateParenthesis {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(sol(s));  // should detect duplicate → true
    }

    public static boolean sol(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // If closing parenthesis ')'
            if (ch == ')') {
                int count = 0;

                // Pop until '('
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                    count++;
                }

                // If no elements between ( )
                if (count == 0) {
                    return true;  // duplicate parentheses found
                }

                // Pop the '('
                stack.pop();

            } else {
                // Push any character except ')'
                stack.push(ch);
            }
        }

        return false; // no duplicates found
    }
}
