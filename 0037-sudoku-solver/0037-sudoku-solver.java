class Solution {
    int[] row = new int[10];
    int[] col = new int[10];
    int[][] mat = new int[3][3];
    
    public boolean isValid(int r, int c ,int num) {
        int mask = 1<<num;
        //Row    
        if((row[r] & mask) != 0)return false;
        //Col
       if((col[c] & mask) != 0)return false;
        //3X3
       if((mat[r/3][c/3] & mask) != 0)return false;
        
        return true;
    }
    
    public void toggle(int r,int c,int num) {
        int mask = 1<<num;
        row[r] ^= mask;
        col[c] ^= mask;
        mat[r/3][c/3] ^= mask;
    }
    
    public boolean SudokuSolver(int idx, ArrayList<Integer> loc, char[][] board) {
        if(idx==loc.size()) {
            return true;
        }
        
        int r = loc.get(idx)/9;
        int c = loc.get(idx)%9;
        boolean res = false;

        for(int number=1;number<=9;number++) {
            if(isValid(r,c,number)) {
                board[r][c] = (char)('0' + number);
                toggle(r,c,number);
                res = res || SudokuSolver(idx+1,loc,board);
                if(res) return true;
                board[r][c] = '.';
                toggle(r,c,number);
            }
        }
        return res;
    }
   
    public void solveSudoku(char[][] board) {
        ArrayList<Integer> loc = new ArrayList<>();
        for(int i=0;i<board.length;i++) {
            for(int j=0; j<board[0].length;j++) {
                if(board[i][j]=='.')
                    loc.add((i*9) + j);
                else
                    toggle(i,j,board[i][j]-'0');
            }
        }
       SudokuSolver(0,loc,board);
    }
}