class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] res = new int[2];
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                res[k] = nums[i];
                k++;
            }
            set.add(nums[i]);
        }
        return res;
    }
}