class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int curr = 0;
        int ans = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                curr = s.charAt(i) - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    curr = curr * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                curr = curr * sign;
                ans += curr;
                curr = 0;
                sign = 0;
            } else if(s.charAt(i) == '+'){
                sign = 1;
            } else if(s.charAt(i) == '-'){
                sign = -1;
            } else if(s.charAt(i) == '('){
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            } else if(s.charAt(i) == ')'){
                int prevSign = stack.pop();
                ans = prevSign * ans;
                int prevAns = stack.pop();
                ans = prevAns + ans;
            }
        }
        return ans;
    }
}