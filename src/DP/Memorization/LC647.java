package DP.Memorization;

public class LC647 {
    public static void main(String[] args) {

        String s = "hello";

        System.out.println(countSubstrings(s));

    }
    public static int countSubstrings(String s) {

        int ans = solve(s,0,s.length()-1,new Boolean[s.length()][s.length()],new Integer[s.length()][s.length()]);

        return ans;
    }
    public static boolean isPalindrome(String s, int i, int j){


        while (i <= j && s.charAt(i)==s.charAt(j)){
//            System.out.println("i :" + i);
//            System.out.println("j :" + j);
            i++;
            j--;
        }

        return j < i;

    }


    public static int solve(String s, int i, int j,Boolean [][] dp,Integer [][] count) {



        if (i > j) {
            return 0;
        }

        if(count[i][j]!=null){
            return count[i][j];
        }

        int ans = 0;

        if(dp[i][j]==null) {
            if (isPalindrome(s, i, j)) {
                ans += 1;
                dp[i][j] = true;
            } else {
                dp[i][j] = false;
            }
        }else if(dp[i][j]) {
            ans++;
        }

        int moveL = solve(s,i+1,j,dp,count);
        int moveR = solve(s,i,j-1,dp,count);
        int bothWays = solve(s,i+1,j-1,dp,count);



        return count[i][j] = moveL + moveR - bothWays+ans;
    }




//
//    public static int solve(String s, int i, int j,Boolean [][] dp) {
//
//
//
//        if (i > j) {
//            return 0;
//        }
//
//        int ans = 0;
//        for (int k = i; k <= j; k++) {
//
//            if(dp[i][k]==null) {
//                if (isPalindrome(s, i, k)) {
//                    dp[i][k] = true;
//                } else {
//                    dp[i][k] = false;
//                }
//            }
//            if(dp[i][k]){
//                ans++;
//            }
//        }
//
//            return solve(s, i + 1, j, dp) + ans;
//
//
//    }
//

}
    //        int ans2  = 0;
//
//
//        // Brute force
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j < s.length(); j++) {
//                if(isPalindrome(s,i,j))
//                    ans2 +=  1;
//            }
//        }
//
//
//




//
//
//        if(i>j){
//            return 0;
//        }
//
//        // recursive brute force
//
//        int ans = 0;
//        for (int k = i; k <= j; k++) {
//            if(isPalindrome(s, k, j)){
//                ans+= 1;
//            }
//        }
//
//        return ans + solve(s, i +1, j);
//
//









// BULL SHIT BELOW


//
//        if(i==j){
//            return 1;
//        }
//        if(i > j){
//            return 0;
//        }
//
//
//        int ans = 0;
//
//        if(s.charAt(i)==s.charAt(j)){
//            if(isPalindrome(s,i,j)){
//                ans+= 1;
//            }
//        }
//
//        ans += solve(s,i+1,j-1);
//        ans += solve(s,i,j-1);
//        ans += solve(s,i+1,j);
//
//        return ans;
//        //
//        if(i > j){
//            return 0;
//        }
//
//
//        if(i==j){
//            return 1;
//        }
//
//
//        int half = (i + j)/2;
//
//        int rightHalf = solve(s,i,half);
//        int leftHalf = solve(s,half+1,j);
//
//        int ans = 0;
//
//        if(s.charAt(i)==s.charAt(j)){
//            ans = 1;
//        }
//
//        return ans + rightHalf + leftHalf;

//        if(i>j){
//            return 0;
//        }
//        if(i==j){
//            return 1;
//        }
//        int moveBoth = solve(s,i+1,j-1);
//        int moveLeft = solve(s,i+1,j);
//        int moveRight =  solve(s,i,j-1);
//
//
//
//        int ans = moveBoth + moveLeft + moveRight;
//
//        System.out.println("B :" + moveBoth);
//
//        System.out.println("mL :" + moveLeft);
//
//        System.out.println("mR :" + moveRight);
//
//
//
//
//        if(s.charAt(i)==s.charAt(j)){
//            ans += 1;
//        }
//
//        return ans;

