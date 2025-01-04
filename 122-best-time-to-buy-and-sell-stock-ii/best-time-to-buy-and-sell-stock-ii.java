class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int max = 0;
        for(int i = 0; i < prices.length - 1; i++){
            buy = prices[i];
            if(prices[i+1] > prices[i]){
                max += (prices[i+1] - prices[i]);
            } else {
                buy = prices[i+1];
            }
        }
        return max;
    }
}