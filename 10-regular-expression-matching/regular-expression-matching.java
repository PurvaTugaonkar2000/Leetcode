enum Result{
    TRUE,FALSE
}
class Solution {
    Result[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Result[s.length() + 1][p.length() + 1];
        return dp(0,0,s,p);
    }
    
    public boolean dp(int i, int j, String s, String p){
        if(memo[i][j] != null){
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if(j == p.length()){
            ans = i == s.length();
        } else {
            boolean match = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        if(j + 1 < p.length() && p.charAt(j+1) == '*'){
            ans = (dp(i, j+2, s, p) || match && dp(i+1, j, s, p));
        } else {
            ans = match && dp(i+1, j+1, s, p);
        }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}