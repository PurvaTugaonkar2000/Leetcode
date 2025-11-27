class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while(start < end){
            char left = s.charAt(start);
            char right = s.charAt(end);
            if(!Character.isLetterOrDigit(left)){
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(right)){
                end--;
                continue;
            }
            if(left != right) return false;
            start++;
            end--;
        }
        return true;
    }
}