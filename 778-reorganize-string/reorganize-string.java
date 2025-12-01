class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int maxFreq = Collections.max(map.values());
        if(maxFreq > (n+1)/2) return "";

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        Map.Entry<Character, Integer> prev = null;

        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> curr = pq.poll();
            sb.append(curr.getKey());

            curr.setValue(curr.getValue() - 1);

            if(prev != null && prev.getValue() > 0){
                pq.offer(prev);
            }
            prev = curr;
        }
        return sb.toString();
    }
}