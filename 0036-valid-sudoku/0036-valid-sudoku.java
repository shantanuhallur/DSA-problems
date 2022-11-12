class Solution {
    
   int[] row = new int[10];
    int[] col = new int[10];
    int[][] mat = new int[3][3];
    
    public void toggle(int r,int c,int num) {
        int mask = 1<<num;
        row[r] ^= mask;
        col[c] ^= mask;
        mat[r/3][c/3] ^= mask;
    }
    
    public boolean isValidSudoku(char[][] board) {
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(board[r][c]!='.'){
                    int mask = 1<<(board[r][c]-'0');
                    if((row[r] & mask) == 0 && (col[c] & mask) == 0 && (mat[r/3][c/3] & mask) ==                            0)toggle(r,c,board[r][c]-'0');
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}