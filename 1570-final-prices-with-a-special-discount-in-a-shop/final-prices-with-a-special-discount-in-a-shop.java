class Solution {
    public int[] finalPrices(int[] prices) {
        //int [] answer = new int[prices.length];
        int[] answer = prices.clone();
        int discount=0;
        for(int i=0; i<prices.length;i++){
            for(int j = i+1; j<prices.length;j++){
                if(prices[j]<=prices[i]){
                    answer[i] = prices[i] - prices[j];
                    break;
                }
            }
            
        }
        return answer;
    }
}