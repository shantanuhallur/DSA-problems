class Solution {
    public void dfs(char[][] board,int row,int col,int[][] dir,int n, int m) {
        board[row][col] = '$';
        
        for(int d=0; d<dir.length;d++) {
            int nrow = row + dir[d][0];
            int ncol = col + dir[d][1];
            
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && board[nrow][ncol]=='O'){
                dfs(board,nrow,ncol,dir,n,m);
            }
        }
    }
    
    public void solve(char[][] board) {
        int[][] dir = {{-1,0},{0,1},{0,-1},{1,0}};
        int n = board.length;
        int m = board[0].length;
        
        for(int i=0;i<n;i++){ //travelling 1st col
            if(board[i][0]== 'O') dfs(board,i,0,dir,n,m);
        }
        
        for(int j=0;j<m;j++){ //travelling 1st row
            if(board[0][j]== 'O') dfs(board,0,j,dir,n,m);
        }
        
        for(int j=0;j<m;j++){ //travelling last row
            if(board[n-1][j]== 'O') dfs(board,n-1,j,dir,n,m);
        }
        
        for(int i=0;i<n;i++){ //travelling last col
            if(board[i][m-1]== 'O') dfs(board,i,m-1,dir,n,m);
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