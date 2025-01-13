class Solution {
    public int minimumLength(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int deletecount = 0;
        for(int frequency : map.values()){
            if(frequency % 2 == 1){
                deletecount += frequency - 1;
            } else {
                deletecount += frequency - 2;
            }
        }
        return s.length() - deletecount;
    }
}