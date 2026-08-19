package DP.Tabulation;

public class LC91 {
    public static void main(String[] args) {
        System.out.println(numDecodings("06"));
    }


    // this is a fibonacci series question
    // I got exactly how to solve this, but the problem was How to manage the range of 10 to 26
    // therefore I had to take help from gemini, 50% because the main point remained
    public static int numDecodings(String s) {

        if( s == null  || s.isEmpty() || s.charAt(0)=='0'){
            return 0;
        }

        int n = s.length();
        int twoBack = 1;
        int oneBack = 1;


        for(int i = 2; i <= n; i++){
            int current = 0;

            int oneDigit = s.charAt(i-1) - '0';
            if(oneDigit!=0){
                current+=oneBack;
            }


            int twoDigit = Integer.parseInt(s.substring(i-2,i));
            if(twoDigit >= 10 && twoDigit <= 26){
                current += twoBack;
            }

            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;
    }


}
