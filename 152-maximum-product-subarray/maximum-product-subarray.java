class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0], min = nums[0], ans = nums[0];

        for(int i = 1; i < n; i++){
            int x = nums[i];
            if(x < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(x, max * x);
            min = Math.min(x, min * x);

            ans = Math.max(ans, max);
        }
        return ans;
    }
}