class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        while(i < j){
            if((nums[i]&1)==1 && (nums[j]&1)==0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            } else if((nums[i]&1) == 0){
                i++;
            } else{
                j--;
            }
        }
        return nums;
    }
}