class Solution {
    public int findMiddleIndex(int[] nums) {
        int total = 0;
        for(int num: nums){
            total += num;
        }
        int leftTotal = 0;
        for(int i = 0; i < nums.length; i++){
            int rightTotal = total - leftTotal - nums[i];
            if(leftTotal == rightTotal){
                return i;
            }
            leftTotal += nums[i];
        }
        return -1;
    }
}