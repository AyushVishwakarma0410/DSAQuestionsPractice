package DP.Memorization;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LC279PerfectSqaures {


    public static void main(String[] args) {
        int n = 12;

        System.out.println(check(n));
    }

    public static int check(int n){

        int max = 1;

        while (max * max <= n){
            max++;
        }
        max--;

        int [] dp = new int[n+1];

        Arrays.fill(dp,-1);
        return call(n,max,dp);


    }

    public static int call(int target, int range,int [] dp){

        if(target==0){
            return 0;
        }

        if(dp[target]!=-1){
            return dp[target];
        }

        int ans = target;
        for (int i = 1; i <= range;i++){
            int subs = target - (i*i);

            if(subs>=0){
                ans = Math.min(ans,call(subs,range,dp));
            }

        }

        return dp[target] = 1 + ans;

    }



}




// TLE
//public static int check(int n){
//
//    int max = 1;
//
//    while (max * max <= n){
//        max++;
//    }
//    max--;
//
//    return call(n,max);
//
//
//}
//
//public static int call(int target, int range){
//
//    if(target==0){
//        return 0;
//    }
//
//    int ans = target;
//    for (int i = 1; i <= range;i++){
//        int subs = target - (i*i);
//
//        if(subs>=0){
//            ans = Math.min(ans,call(subs,range));
//        }
//
//    }
//
//    return 1 + ans;
//
//}
