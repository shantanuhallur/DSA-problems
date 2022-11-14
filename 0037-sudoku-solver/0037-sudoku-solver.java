class Solution {
    
    int[] row = new int[10];
    int[] col = new int[10];
    int[][] mat = new int[3][3];
    
    public void toggle(int r , int c , int num) {
        int mask = 1<<num;
        row[r] ^= mask;
        col[c] ^= mask;
        mat[r/3][c/3] ^= mask;
    }
    
    public boolean sudokuSolver(ArrayList<Integer> list,int idx,char[][] board) {
        if(idx == list.size()) {
            return true;
        }
        int r = list.get(idx)/9;
        int c = list.get(idx)%9;
        boolean res = false;
        for(int number = 1; number<=9;number++) {
            int mask = 1<<number;
            if((row[r]&mask)== 0 && (col[c]&mask)==0 && (mat[r/3][c/3]&mask)==0) {
                board[r][c] = (char)(number+'0');
                toggle(r,c,number);
                res = res | sudokuSolver(list,idx+1,board);
                    if(res)return true;
                board[r][c] = '.';
                toggle(r,c,number);
            }
        }
        return res;
    }
    
    public void solveSudoku(char[][] board) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='.')list.add(i*9 + j);
                else toggle(i,j,board[i][j]-'0');
            }
        }
        sudokuSolver(list,0,board);
    }
}