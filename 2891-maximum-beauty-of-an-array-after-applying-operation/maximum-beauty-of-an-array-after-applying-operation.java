class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int left  = 0;
        int result = 0;
        for(int right = 0; right<nums.length; right++){
            while(nums[right] - nums[left] > 2*k){
                left++;
            }
            result = Math.max(result, right - left +1);
        }
        return result;
}
}