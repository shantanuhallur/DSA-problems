class Solution {
    
    public boolean isValid(int r, int c , char[][] board) {
        //Row    
        for(int j=0;j<9;j++){
                if(j!=c && board[r][j] == board[r][c]) return false;                
            }
        
        //Col
        for(int i=0; i<9; i++){
                if(i!=r && board[i][c] == board[r][c]) return false;                
            }
        
        //3X3
        char val = board[r][c];
        int old_r = r;
        int old_c = c;
        r = (r/3)*3;
        c = (c/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int new_r = r+i;
                int new_c = c+j;
                if(new_r != old_r && new_c != old_c && board[new_r][new_c]==val)return false;
            }
        }
            return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(board[r][c]!='.'){
                    if(!isValid(r,c,board))return false;                    
                }
            }
        }
        return true;
    }
}