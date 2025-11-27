class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null && strs.length==0) return "";

        String str = strs[0];
        int n = strs.length;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            for(int j = 1; j < n; j++){
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return str.substring(0,i);
                }
            }
        }
        return str;
    }
}