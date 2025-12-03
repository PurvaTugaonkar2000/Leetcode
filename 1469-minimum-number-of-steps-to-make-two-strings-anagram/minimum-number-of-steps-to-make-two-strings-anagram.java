class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        int steps = 0;

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            Integer count = map.get(c);

            if(count != null && count > 0){
                map.put(c, count - 1);
            } else {
                steps++;
            }
        }
        return steps;
    }
}