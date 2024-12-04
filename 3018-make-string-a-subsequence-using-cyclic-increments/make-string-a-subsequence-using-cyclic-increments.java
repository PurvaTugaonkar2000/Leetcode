class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int str1Idx = 0;
        int str2Idx = 0;
        int str1Len = str1.length();
        int str2Len = str2.length();
        while(str1Idx < str1Len && str2Idx < str2Len){
            char currstr1 = str1.charAt(str1Idx);
            char currstr2 = str2.charAt(str2Idx);
            if(currstr1 == currstr2 || (currstr1 == 'z' && currstr2 == 'a') || currstr1 + 1 == currstr2){
                str1Idx++;
                str2Idx++;
            }
            else{
                str1Idx++;
            }
        }
        return str2Idx == str2Len;
    }
}