class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length; int col = grid[0].length; 
        int time = 0;

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j]==2) q.add(new int[]{i,j});
            }
        }
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!q.isEmpty()){
            boolean rotted = false;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for(int[] direction: directions){
                    int newRow = r + direction[0];
                    int newCol = c + direction[1];
                    if(newRow>=0 && newCol>=0 && newRow < row && newCol < col && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        q.add(new int[]{newRow, newCol});
                        rotted = true;
                    }
                }
            }
            if(rotted) time++;
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return time;
    }
}