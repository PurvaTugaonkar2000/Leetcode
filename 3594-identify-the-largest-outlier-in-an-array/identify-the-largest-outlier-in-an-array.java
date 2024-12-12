class Solution {
    public int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int totalsum = 0;
        for(int num: nums){
            totalsum+=num;
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int maxOutlier = Integer.MIN_VALUE;
        for(int num:nums){
            int rem = totalsum - num;
            if(rem%2!=0) continue;
            int specialSum = rem/2;
            map.put(num ,  map.get(num)-1);
            int count = map.getOrDefault(specialSum,0);
            if(count > 0) maxOutlier = Math.max(maxOutlier, num);
            map.put(num, map.get(num)+1);
        }
        return maxOutlier;

    }
}