package QuestionSheetAlpha.ArrayQuestions;

public class BuyAndSellStocks {
    public static int buySellStocks(int [] prices){
        if(prices.length == 0) return 0;
        int maxProfit = 0;
        int buy = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length;i++){
            if(prices[i]< buy){
                buy = prices[i];
            }else {
                profit = prices[i] - buy;
            }
            maxProfit = Math.max(profit,maxProfit);
        }
        return maxProfit;

    }

    public static void main(String[] args) {
        int [] arr= {};
        // 1 3 5 4 2
        // 1 3 2
        // 3 2 1
        System.out.println(buySellStocks(arr));


    }
}
