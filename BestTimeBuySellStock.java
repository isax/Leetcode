public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int max_diff = 0;
        int low = prices[0];
        for(int i = 1; i<prices.length; i++){
            if(prices[i-1]<low){
                low = prices[i-1];
            }
            int diff = prices[i] - low;
            if(diff>max_diff){
                max_diff = diff;
            }
        }
        return max_diff;
    }
}
