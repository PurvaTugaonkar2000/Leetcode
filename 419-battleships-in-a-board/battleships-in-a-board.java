class Solution {
    public int countBattleships(char[][] board) {
        if(board == null || board.length == 0) return 0;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'X' && !visited[i][j]){
                    count++;
                    dfs(board, visited, i ,j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] board, boolean[][] visited, int i, int j) {
        int m = board.length, n = board[0].length;
        if(i < 0 || i >=m || j < 0 || j >= n) return;
        if(visited[i][j] || board[i][j] != 'X') return;

        visited[i][j] = true;

        dfs(board, visited, i+1, j);
        dfs(board, visited, i-1, j);
        dfs(board, visited, i, j+1);
        dfs(board, visited, i, j-1);
    }
}