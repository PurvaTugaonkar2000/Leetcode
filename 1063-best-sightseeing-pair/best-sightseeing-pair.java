class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = 0;
        int m = values[0];
        for(int i = 1; i < values.length; i++){
            if(values[i] - i + m > max) max = values[i] - i + m;
            if(values[i] + i > m) m = values[i]+i;
        }
        return max;
    }
}