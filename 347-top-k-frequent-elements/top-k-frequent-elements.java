class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a,b) -> Integer.compare(b.getValue(), a.getValue()));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            heap.offer(entry);
        }
        int[] output = new int[k];
        for(int i = 0; i < k; i++){
            output[i] = heap.poll().getKey();
        }
        return output;
    }
}