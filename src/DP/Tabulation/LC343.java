package DP.Tabulation;

public class LC343 {

    // Finally a self done question

    //  look at this if doing revision for (int j = 1; j < i; j++) {
    //     // Compare 'current best' vs 'new product option using split j'
    //     dp[i] = Math.max(dp[i], j * Math.max(dp[i-j], i - j));
    // }

    public static void main(String[] args) {


        int n = 5;

        System.out.println(integerBreak(n));
    }

    public static int integerBreak(int n) {


        // base cases
        if(n<=2){
            return n;
        }
        if(n==3){
            return 2;
        }


        int ans = 0;
        for (int i = 1; i < n;i++){
            int num = n - i;
            ans = Math.max(integerBreak(num)*i,ans);
        }

        return ans;

    }
}

