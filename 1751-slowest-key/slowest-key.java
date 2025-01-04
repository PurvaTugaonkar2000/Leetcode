class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        Map<Character, Integer> map = new HashMap<>();
        map.put(keysPressed.charAt(0), releaseTimes[0]);
        for(int i = 1; i < releaseTimes.length; i++){
            int currtime = releaseTimes[i] - releaseTimes[i-1];
            char currentkey = keysPressed.charAt(i);
            map.put(currentkey, Math.max(map.getOrDefault(currentkey, 0), currtime));
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        Character maxKey=null;
        int maxValue = Integer.MIN_VALUE;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            char key = entry.getKey();
            int value = entry.getValue();
            if (value > maxValue || (value == maxValue && key > maxKey)) {
                maxValue = value;
                maxKey = key;
            }
        }
        return maxKey;
    }
}