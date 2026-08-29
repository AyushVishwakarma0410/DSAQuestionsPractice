package DP.Memorization;




public class LC516 {


    public static void main(String[] args) {

        String s = "bbbab";

        System.out.println("ans" + longestPalindromeSubseq(s));


    }

    // accidentally saw a hint about this, but already guessed how I do it
    // memorization
    // self done kinda

    public static int longestPalindromeSubseq(String s) {

        int i = 0;
        int j = s.length()-1;
        Integer [][] dp = new Integer[s.length()][s.length()];

        int ans = solve(s,i,j,dp);


        return ans;


    }

    public static int solve(String s, int i, int j, Integer [][] dp){

        if(i  > j){
            return 0;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        int ans ;
        if(s.charAt(i)==s.charAt(j)){
            if(i==j){
                ans = 1;
            }else {
                ans = 2 + solve(s, i + 1, j - 1,dp);
            }
        }else {
            ans = Math.max(solve(s,i+1,j,dp),solve(s,i,j-1,dp));
        }

        return dp[i][j] =  ans;

    }






    // brute force
    /*

    public static int longestPalindromeSubseq(String s) {

        int i = 0;
        int j = s.length()-1;


        int ans = solve(s,i,j);


        return ans;


    }

    public static int solve(String s, int i, int j){

        if(i  > j){
            return 0;
        }
        int ans ;
        if(s.charAt(i)==s.charAt(j)){
            if(i==j){
                ans = 1;
            }else {
                ans = 2 + solve(s, i + 1, j - 1);
            }
        }else {
            ans = Math.max(solve(s,i+1,j),solve(s,i,j-1));
        }

        return ans;

    }

     */
}
