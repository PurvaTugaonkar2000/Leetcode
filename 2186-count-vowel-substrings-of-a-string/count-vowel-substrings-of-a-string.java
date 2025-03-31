class Solution {
    public int countVowelSubstrings(String word) {
        Set<Character> vowels = Set.of('a','e','i','o','u');
        int n = word.length();
        int left = 0;
        int count = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < n; i++){
            char c = word.charAt(i);
            if(!vowels.contains(c)){
                freq.clear();
                left = i + 1;
                continue;
            }
            freq.put(c, i);

            if(freq.size() == 5){
                int min = Integer.MAX_VALUE;
                for(int index : freq.values()){
                    min = Math.min(min, index);
                }
                count += min - left + 1;
            }
        }
        return count;

    }
}