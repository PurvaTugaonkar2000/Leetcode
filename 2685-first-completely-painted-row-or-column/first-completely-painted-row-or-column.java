class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        for(int r = 0; r < mat.length; r++){
            for(int c = 0; c < mat[0].length; c++){
                map.put(mat[r][c], new int[]{r,c});
            }
        }
        for(int i = 0; i < arr.length; i++){
            int[] coordinate = map.get(arr[i]);
            int r = coordinate[0];
            int c = coordinate[1];

            row[r]++;
            col[c]++;
            if(row[r] == mat[0].length || col[c] == mat.length){
                return i;
            } 
        }
        return 1;
    }
}