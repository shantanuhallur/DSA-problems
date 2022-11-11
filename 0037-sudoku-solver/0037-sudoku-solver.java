class Solution {
    public boolean isValid(int r, int c , char[][] board,int num) {
        //Row    
        for(int j=0;j<9;j++){
                if(board[r][j]-'0' == num) return false;                
            }
        //Col
        for(int i=0; i<9; i++){
                if(board[i][c]-'0' == num) return false;                
            }
        //3X3
        r = (r/3)*3;
        c = (c/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[r+i][c+j]-'0' == num)return false;
            }
        }
            return true;
    }
    
    public boolean SudokuSolver(int idx, ArrayList<Integer> loc, char[][] board) {
        if(idx==loc.size()) {
            return true;
        }
        
        int r = loc.get(idx)/9;
        int c = loc.get(idx)%9;
        boolean res = false;

        for(int number=1;number<=9;number++) {
            if(isValid(r,c,board,number)) {
                board[r][c] = (char)('0' + number);
                res = res || SudokuSolver(idx+1,loc,board);
                if(res) return true;
                board[r][c] = '.';
            }
        }
        return res;
    }
   
    public void solveSudoku(char[][] board) {
        ArrayList<Integer> loc = new ArrayList<>();
        for(int i=0;i<board.length;i++) {
            for(int j=0; j<board[0].length;j++) {
                if(board[i][j]=='.')loc.add((i*9) + j);
            }
        }
       SudokuSolver(0,loc,board);
    }
}