class Solution {
        int row;
        int col;
        Set<Pair<Integer, Integer>> path = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(dfs(board, word, r,c,0)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int r, int c, int i){
        if(i == word.length()) return true;
        if(r < 0 || c < 0 || r >= row || c >= col || board[r][c] != word.charAt(i) || path.contains(new Pair<>(r,c))) return false;
        path.add(new Pair<>(r,c));
        boolean res = dfs(board, word, r+1, c, i+1) ||
                      dfs(board, word, r-1, c, i+1) ||
                      dfs(board, word, r, c+1, i+1) ||
                      dfs(board, word, r, c-1, i+1);
        
        path.remove(new Pair<>(r,c));
        return res;
    }
}