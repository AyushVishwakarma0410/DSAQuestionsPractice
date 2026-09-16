package DP.Memorization;

import java.util.Arrays;

public class LC1246 {

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 5};

        boolean[] visited = new boolean[arr.length];

        System.out.println(solve(arr, 0, arr.length, visited));
    }

    public static int solve(int[] arr, int start, int end, boolean[] visited) {

        // Nothing remains
        if (allVisited(visited)) {
            return 0;
        }

        // Whole remaining array is a palindrome
        if (isPalindrome2(arr, start, end - 1, visited)) {
            return 1;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < end; i++) {

            // Odd length palindrome
            int[] even = isPalindrome(arr, i, i, visited);

            boolean[] newVis = Arrays.copyOf(visited, visited.length);

            for (int j = even[0]; j <= even[1]; j++) {
                if (!visited[j]) {
                    newVis[j] = true;
                }
            }

            ans = Math.min(ans,
                    1 + solve(arr, start, end, newVis));


            // Even length palindrome
            if (i + 1 < end) {

                int[] odd = isPalindrome(arr, i, i + 1, visited);

                newVis = Arrays.copyOf(visited, visited.length);

                for (int j = odd[0]; j <= odd[1]; j++) {
                    if (!visited[j]) {
                        newVis[j] = true;
                    }
                }

                ans = Math.min(ans,
                        1 + solve(arr, start, end, newVis));
            }
        }

        return ans;
    }


    public static int[] isPalindrome(
            int[] arr, int i, int j, boolean[] visited) {

        while (i >= 0 && j < visited.length
                && arr[i] == arr[j]) {

            i--;
            j++;

            while (i >= 0 && visited[i]) {
                i--;
            }

            while (j < visited.length && visited[j]) {
                j++;
            }
        }

        return new int[]{i + 1, j - 1};
    }


    public static boolean isPalindrome2(
            int[] arr, int i, int j, boolean[] visited) {

        while (i <= j) {

            while (i <= j && visited[i]) {
                i++;
            }

            while (i <= j && visited[j]) {
                j--;
            }

            if (i > j) {
                break;
            }

            if (arr[i] != arr[j]) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }


    public static boolean allVisited(boolean[] visited) {

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }
}