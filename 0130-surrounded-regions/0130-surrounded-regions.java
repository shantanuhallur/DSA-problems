class Solution {
    public void dfsSurroundedRegions(char[][] board,int row,int col,int[][] dir,int n, int m) {
        board[row][col] = '$';
        
        for(int d=0; d<dir.length;d++) {
            int nrow = row + dir[d][0];
            int ncol = col + dir[d][1];
            
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && board[nrow][ncol]=='O'){
                dfsSurroundedRegions(board,nrow,ncol,dir,n,m);
            }
        }
    }
    
    public void solve(char[][] board) {
        int[][] dir = {{-1,0},{0,1},{0,-1},{1,0}};
        int n = board.length;
        int m = board[0].length;
        
        for(int i=0;i<n;i++){ //travelling 1st col and last col
            if(board[i][0]== 'O') dfsSurroundedRegions(board,i,0,dir,n,m);
            if(board[i][m-1]== 'O') dfsSurroundedRegions(board,i,m-1,dir,n,m);
        }
        
        for(int j=0;j<m;j++){ //travelling 1st row and last row
            if(board[0][j]== 'O') dfsSurroundedRegions(board,0,j,dir,n,m);
            if(board[n-1][j]== 'O') dfsSurroundedRegions(board,n-1,j,dir,n,m);
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j]=='$'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}