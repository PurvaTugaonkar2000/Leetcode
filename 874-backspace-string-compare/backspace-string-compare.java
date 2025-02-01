class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int k = process(sChars);
        int p = process(tChars);
        if(k != p){
            return false;
        }
        for(int i = 0; i < k; i++){
            if(sChars[i] != tChars[i]) return false;
        }
        return true;
    }
    private int process(char[] chars){
        int k = 0;
        for(char c: chars){
            if(c != '#'){
                chars[k++] = c;
            } else if(k > 0){
                k--;
            }
        }
        return k;
    }
}