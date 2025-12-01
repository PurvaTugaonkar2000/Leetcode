class Solution {
    public int myAtoi(String s) {
        if(s == null || s.length() == 0) return 0;

        int i = 0, n = s.length();
        //1. check for whitespaces
        while(i < n && s.charAt(i) == ' '){
            i++;
        }
        if(i == n) return 0;

        // 2 sign
        int sign = 1;
        char ch = s.charAt(i);
        if(ch == '+' || ch == '-'){
            if(ch == '-') sign = -1;
            i++;
        }

        //3 conversion
        int result = 0;
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;

        while(i < n){
            int c = s.charAt(i);
            if(c < '0' || c > '9') break;

            int digit = c - '0';
            if(result > INT_MAX / 10 || (result == INT_MAX / 10 && digit > INT_MAX % 10)){
                return (sign == 1) ? INT_MAX: INT_MIN;
            }
            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }
}