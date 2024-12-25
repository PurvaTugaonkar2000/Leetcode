class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int area = 0;
        int[][] visited = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    area = Math.max(area, area(i,j,grid,visited));
                }
            }
        }
        return area;
    }
    public int area(int r, int c, int[][] grid, int[][] visited){
        if(r >=0 && r<grid.length && c >=0 && c < grid[0].length && visited[r][c]==0 && grid[r][c] == 1){
            visited[r][c] =1;
            return (1 + area(r+1,c,grid,visited) + area(r-1,c,grid,visited) + area(r, c+1, grid, visited) + area(r, c-1, grid, visited));
        }
        return 0;
    }
}