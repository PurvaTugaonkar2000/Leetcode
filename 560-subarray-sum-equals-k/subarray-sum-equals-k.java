class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> presum = new HashMap<>();
        presum.put(0,1);
        int total = 0, count = 0;
        for(int n: nums){
            total += n;
            if(presum.containsKey(total - k)){
                count += presum.get(total - k);
            }
            presum.put(total, presum.getOrDefault(total, 0) + 1);
        }
        return count;
    }
}