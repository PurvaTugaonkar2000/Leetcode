class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int xor1 = 0;
        int xor2 = 0;
        if(l2 % 2!= 0){
            for(int num: nums1){
                xor1 ^= num;
            }
        }
        if(l1 % 2!= 0){
            for(int num: nums2){
                xor2 ^= num;
            }
        }
        return xor1 ^ xor2;
    }
}