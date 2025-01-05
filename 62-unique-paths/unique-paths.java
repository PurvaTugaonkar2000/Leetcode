class Solution {
    public int uniquePaths(int m, int n) {
        int[] belowRow = new int[n];
        Arrays.fill(belowRow, 1);
        for(int row = 1; row < m; row++){
            int[] currentRow = new int[n];
            Arrays.fill(currentRow, 1);
            for(int col = n-2; col >=0; col --){
                currentRow[col] = currentRow[col + 1] + belowRow[col];
            }
            belowRow = currentRow;
        }
        return belowRow[0];
    }
}