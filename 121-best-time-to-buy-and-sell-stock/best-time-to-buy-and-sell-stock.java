class Solution {
    public int maxProfit(int[] prices) {
       int max = 0, buy = Integer.MAX_VALUE;
       for(int i =0; i < prices.length; i++){
        if(buy>prices[i]){
            buy = prices[i];
        }
        else{
            int profit = prices[i] - buy;
            max = Math.max(profit, max);
        }
        }
        return max; 
    }
}