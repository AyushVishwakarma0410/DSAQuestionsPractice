package DP.Tabulation;

public class LC122 {
    public int maxProfit(int[] prices) {

        if(prices.length <= 0){
            return 0;
        }

        int sum = 0;
        int prevValue = prices[0];

        for(int i = 1; i<prices.length; i++){
            int calculatedProfit = prices[i] - prevValue;
            if(calculatedProfit > 0){
                sum+=calculatedProfit;
            }
            prevValue = prices[i];
        }

        return sum;
    }
}
