class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()) return result;
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0)+1);
        }
        for(int i = 0; i < s.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+ 1);
            if(i >= p.length()){
                char toremove = s.charAt(i - p.length());
                if(sMap.get(toremove) == 1){
                    sMap.remove(toremove);
                }else {
                    sMap.put(toremove, sMap.getOrDefault(toremove, 0) - 1);
                }
            }
            if(pMap.equals(sMap)){
                result.add(i - p.length() +1);
            }
        }
        return result;
    }
}