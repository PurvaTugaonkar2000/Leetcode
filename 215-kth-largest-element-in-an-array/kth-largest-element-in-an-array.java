class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++){
            maxheap.add(nums[i]);
        }
        int res = 0;
        for(int i = 0; i < k; i++){
            res = maxheap.poll();
        }
        return res;
    }
}