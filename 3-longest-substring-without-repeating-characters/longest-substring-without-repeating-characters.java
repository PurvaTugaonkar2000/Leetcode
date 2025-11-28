class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < s.length();right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch) && map.get(ch)>= left){
                left = map.get(ch) + 1;
            }
            max = Math.max(max, right - left + 1);
            map.put(ch, right);
        }
        return max;
    }
}