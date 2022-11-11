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
    
    public boolean SudokuSolver(int idx, char[][] board , ArrayList<Integer> loc) {
        if(idx == loc.size()) {
            return true;
        }
        int r = loc.get(idx)/9;
        int c = loc.get(idx)%9;
        boolean res = false;

        for(int num=1;num<=9;num++) {
            if(isValid(r,c,board,num)) {
                board[r][c] = (char)('0' + num);
                res= res || SudokuSolver(idx+1,board,loc);
                if(res) return true;
                board[r][c] = '.';
            }
        }
        return res;
    }
    
    public void solveSudoku(char[][] board) {
        ArrayList<Integer> loc = new ArrayList<>();
        int n = 9;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    loc.add(i * n + j);
                }

            }
        }
        
       SudokuSolver(0,board,loc);
}
}