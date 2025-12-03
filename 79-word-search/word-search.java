class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(dfs(r,c, 0, word, board)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int r, int c, int idx, String word, char[][] board){
        int rows = board.length;
        int cols = board[0].length;
        if(idx == word.length()) return true;

        if(r < 0 || r >= rows || c < 0 || c >= cols) return false;
        if(board[r][c] != word.charAt(idx)) return false;

        char temp = board[r][c];
        board[r][c] = '#';

        boolean found = dfs(r - 1, c, idx + 1, word, board)
        || dfs(r + 1, c, idx + 1, word, board) || dfs(r, c-1, idx+1, word, board) || dfs(r, c+1, idx + 1, word, board);

        board[r][c] = temp;

        return found;
    }
}