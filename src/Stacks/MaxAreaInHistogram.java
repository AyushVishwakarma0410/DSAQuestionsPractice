package Stacks;

import java.util.Stack;

public class MaxAreaInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        maxArea(heights);
    }

    public static void maxArea(int[] heights) {

        int[] prevSmallest = prevSmallest(heights);
        int[] nextSmallest = nextSmallest(heights);

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = nextSmallest[i] - prevSmallest[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        System.out.println(maxArea);
    }

    // previous smaller (left)
    public static int[] prevSmallest(int[] arr) {

        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();

            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return ans;
    }

    // next smaller (right)
    public static int[] nextSmallest(int[] arr) {

        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();

            ans[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }

        return ans;
    }
}
