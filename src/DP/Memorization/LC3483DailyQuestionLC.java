package DP.Memorization;

import java.util.HashSet;

public class LC3483DailyQuestionLC {

    public static void main(String[] args) {
        int [] digits = {6,6,6};

        System.out.println();

        System.out.println(totalNumbers(digits));
    }
    public static int totalNumbers(int[] digits) {


        int ans = 0;

        HashSet<Integer> set = new HashSet<>();

        for(int i =0 ; i < digits.length;i++){
            for(int j =0; j < digits.length;j++){
                if(i==j){
                    continue;
                }
                for(int k = 0; k < digits.length; k++){
                    if(k==i || k == j){
                        continue;
                    }

                    int first = digits[i]*10;
                    int second = (first + digits[j])*10;
                    int third = second + digits[k];

                    if(third % 2 == 0 && third > 99 && third < 1000&& !set.contains(third)){
                        ans++;
                        set.add(third);

                    }

                }
            }
        }

        return ans;


    }



}
