class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        StringBuilder res = new StringBuilder();
        while(maxHeap.size() > 1){
            char char1 = maxHeap.poll();
            res.append(char1);
            map.put(char1, map.getOrDefault(char1,0)-1);
            char char2 = maxHeap.poll();
            res.append(char2);
            map.put(char2, map.getOrDefault(char2,0)-1);

            if(map.get(char1) > 0){
                maxHeap.add(char1);
            }
            if(map.get(char2) > 0){
                maxHeap.add(char2);
            }
        }
        if(!maxHeap.isEmpty()){
            char ch = maxHeap.poll();
            if(map.get(ch) > 1) return "";
            res.append(ch);
        }
        return res.toString();
    }
}