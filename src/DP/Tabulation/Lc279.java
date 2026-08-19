package DP.Tabulation;

public class Lc279 {

    // DP
    public int numSquares(int n) {
        // dp[i] will store the minimum number of perfect squares that sum to i
        int[] dp = new int[n + 1];

        // Fill the array with a high value (like n, since 1^2 used n times is the worst case)
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    // Lagrange's 4 square theorem

    class Solution {
        public int numSquares(int n) {
            // 1. Check if n is a perfect square (Answer = 1)
            if (isSquare(n)) {
                return 1;
            }

            // 2. Check if n is of the form 4^a * (8b + 7) (Answer = 4)
            int temp = n;
            while (temp % 4 == 0) {
                temp /= 4;
            }
            if (temp % 8 == 7) {
                return 4;
            }

            // 3. Check if n can be written as a sum of two squares (Answer = 2)
            for (int i = 1; i * i <= n; i++) {
                if (isSquare(n - i * i)) {
                    return 2;
                }
            }

            // 4. If none of the above, answer must be 3
            return 3;
        }

        private boolean isSquare(int n) {
            int root = (int) Math.sqrt(n);
            return root * root == n;
        }
    }
}



// failed attempt
//public static int check(int n ){
//
//    int max = 1;
//    while (max * max <= n){
//        max++;
//    }
//    max--;
//
//    int end = max;
//
//    int res = n;
//
//
//    // main loop for decreasing values continuously
//    while (end!=0){
//        int ans = 0;
//        int current = end;
//        int target = n;
//        // for the current square calculating values
//        while (target!=0){
//
//            if(target >= current*current) {
//                target -= current * current;
//                ans++;
//
//            }
//            // Decreasing values
//            while (target<current*current){
//                current--;
//            }
//        }
//
//        // result
//        res = Math.min(res,ans);
//
//
//
//        end--;
//    }
//
//
//    return res;
//
//}
//

