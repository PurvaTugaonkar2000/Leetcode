class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 2;
        if(n<=2){
            return n;
        }
        for(int i = 2; i <nums.length;i++){
            if(nums[j-2]!=nums[i]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}