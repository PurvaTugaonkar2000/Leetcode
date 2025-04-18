class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for(int i = 0; i < 9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if(board[r][c]=='.') continue;
                char value = board[r][c];
                int boxindex = (r/3)* 3 + (c/3);

                if(rows[r].contains(value) || cols[c].contains(value) || boxes[boxindex].contains(value)){
                    return false;
                }
                rows[r].add(value);
                cols[c].add(value);
                boxes[boxindex].add(value);
            }
        }
        return true;
    }
}