class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices  = new int[n];
        for(int i = 0; i < n; i++){
            prices[i] = Integer.MAX_VALUE;
                    prices[src] = 0;
        }
        for(int i = 0; i < k+1; i++){
            int[] temp = Arrays.copyOf(prices, n);

        for(int[] flight: flights){
            int s = flight[0];
            int d = flight[1];
            int p = flight[2];
            if(prices[s] == Integer.MAX_VALUE){
                continue;
            }
            if(prices[s] + p < temp[d]){
                temp[d] = prices[s] + p;
            }

        }
        prices = temp;
    }
    if(prices[dst] == Integer.MAX_VALUE) {
        return -1;
    }
    else {
        return prices[dst];
    }
    }
}