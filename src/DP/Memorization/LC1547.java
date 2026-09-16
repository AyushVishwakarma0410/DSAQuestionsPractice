package DP.Memorization;

import java.util.Arrays;

public class LC1547 {

    public static void main(String[] args) {


        int[] arr = {5,6,1,4,2};
        int n = 9;

        int length = arr.length - 1;



        int [] updated = new int[arr.length+2];
        updated[0] = 0;
        updated[updated.length-1] = n;

        for (int i = 1; i < updated.length-1; i++){
            updated[i] = arr[i-1];
        }

        int[][] dp = new int[updated.length+1][updated.length+1];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        Arrays.sort(updated);


        System.out.println(solve(updated,0,updated.length-1,dp));

//        System.out.println(solve(arr, 0, n, 0, arr.length,dp));
    }





    public static int solve(int [] arr,  int start, int end,int [][] dp){

        if(start+1>=end){
            return 0;
        }

        if(dp[start][end]!=-1){
            return dp[start][end];
        }

        int current = arr[end] - arr[start];

        int ans = Integer.MAX_VALUE;

        for (int i = start+1; i < end; i++) {

            int left = solve(arr,start,i,dp);
            int right = solve(arr,i,end,dp);

            ans = Math.min(ans,left+right+current);

        }


        return dp[start][end] = ans;

    }









        // took help before
    // I got jumbled with ideas
    public static int solve(int [] arr,  int startStick, int endStick, int startIDX, int endEND,int [][] dp){


        if(startIDX>=endEND){
            return 0;
        }

        if(startStick >= endStick){
            return 0;
        }

        if(dp[startIDX][endEND]!=-1){
            return dp[startIDX][endEND];
        }

        int ans = Integer.MAX_VALUE;
        int current = endStick-startStick;
        for (int i = startIDX; i < endEND; i++) {

            //left
            int startstickforleft = startStick;
            int endstickforleft = arr[i];
            int startidxforLeft = startIDX;
            int endIDXofLeft = i;

            int left = solve(arr,startstickforleft,endstickforleft,startidxforLeft,endIDXofLeft,dp);

            int startstickForRight = arr[i];
            int endStickForRight = endStick;
            int startidxForRight = i+1;
            int endIdxForRight = endEND;

            int right = solve(arr,startstickForRight,endStickForRight,startidxForRight,endIdxForRight,dp);

            ans = Math.min(ans,left+right+current);


        }

        // System.out.println("start idx : "+startIDX + "  "+  "end Idx : "+ endEND);
        // System.out.println(ans);
        return dp[startIDX][endEND] = ans;



    }

    // MLE
//    public static int solve(int [] arr,  int startStick, int endStick, int startIDX, int endEND){
//
//
//        if(startIDX>=endEND){
//            return 0;
//        }
//
//        if(startStick >= endStick){
//            return 0;
//        }
//
//        int ans = Integer.MAX_VALUE;
//        int current = endStick-startStick;
//        for (int i = startIDX; i < endEND; i++) {
//
//            //left
//            int endstickforleft = arr[i];
//
//            int left = solve(arr, startStick,endstickforleft, startIDX, i);
//
//            int startstickForRight = arr[i];
//            int startidxForRight = i+1;
//
//            int right = solve(arr,startstickForRight, endStick,startidxForRight, endEND);
//
//            ans = Math.min(ans,left+right+current);
//
//
//        }
//
//        System.out.println("start idx : "+startIDX + "  "+  "end Idx : "+ endEND);
//        System.out.println(ans);
//        return ans;
//
//    }
}
