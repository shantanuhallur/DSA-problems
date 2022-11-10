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
        board[r][c] = '*';
        r = (r/3)*3;
        c = (c/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[r+i][c+j]==val)return false;
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