class Solution {
    public List<String> commonChars(String[] words) {
        int[] last = count(words[0]);
        for(int i = 1; i < words.length; i++){
            last = intersect(last, count(words[i]));
        }
        List<String> result = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            if(last[i]!= 0){
                char ch = (char)('a'+i);
                String s = String.valueOf(ch);
                while(last[i] > 0){
                    result.add(s);
                    last[i]--;
                }
            }
        }
        return result;
    }
    private int[] intersect(int[] a, int[] b){
        int[] res = new int[26];
        for(int i = 0; i < 26; i++){
            res[i] = Math.min(a[i], b[i]);
        }
        return res;
    }
    private int[] count(String str){
        int[] res = new int[26];
        for(char ch : str.toCharArray()){
            res[ch - 'a']++;
        }
        return res;
    }
}