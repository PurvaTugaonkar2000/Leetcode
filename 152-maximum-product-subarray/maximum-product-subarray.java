class Solution {
    public int maxProduct(int[] nums) {
        int currmin = 1;
        int currmax = 1;
        int result = nums[0];
        for(int n: nums){
            if(n == 0){
                currmin = 1;
                currmax = 1;
            }
            int temp = currmax * n;
            currmax = Math.max(Math.max(n * currmax, n * currmin), n);
            currmin = Math.min(Math.min(temp, n * currmin), n);
            result = Math.max(result, currmax);
        }
        return result;
    }
}