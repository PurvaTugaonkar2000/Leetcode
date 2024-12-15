class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int left=0, right=0;
        for(int i = 0; i<s.length(); i++){
            left=i;
            right = i;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                if((right - left +1) > result.length()){
                    result = s.substring(left, right+1);
                }
                left-=1;
                right+=1;
            }

            left=i;
            right = i+1;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                if((right - left +1) > result.length()){
                    result = s.substring(left, right+1);
                }
                left-=1;
                right+=1;
            }
        }
        return result;
    }
}