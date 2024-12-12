class Solution {
    public void dfs(int i, int j, char[][] visited, char[][] grid, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j]=='1' ||grid[i][j]=='0'){
            return;
        }
        visited[i][j] = '1';
        dfs(i-1, j, visited, grid, m,n);
        dfs(i+1, j, visited, grid, m, n);
        dfs(i, j-1, visited, grid, m, n);
        dfs(i, j+1, visited, grid, m, n);

    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        char[][] visited = new char[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                visited[i][j] = '0';
                }
            }
        int islands = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == '0' && grid[i][j]=='1'){
                    islands+=1;
                    dfs(i,j,visited, grid, m, n);
                }
            }
        }
        return islands;
    }
}