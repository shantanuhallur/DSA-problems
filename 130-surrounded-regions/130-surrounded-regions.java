class Solution {
    public void solve(char[][] board) {
       int rows = board.length;
        int cols = board[0].length;
        
        for(int i=0;i<rows;i++){
            if(board[i][0] == 'O')dfs(board,i,0);
            if(board[i][cols-1] == 'O')dfs(board,i,cols-1);
        }
        
        for(int i=0;i<cols;i++){
            if(board[0][i] == 'O')dfs(board,0,i);
            if(board[rows-1][i] == 'O')dfs(board,rows-1,i);
        }
        
        for(int i=0 ; i<rows ; i++){
            for(int j=0 ; j<cols ; j++){
                if(board[i][j]=='O'){
                    board[i][j] ='X';
                }
                else if (board[i][j]=='*'){
                    board[i][j]='O';
                }
            }
        }
    }
    
    public void dfs(char[][] board,int row,int col){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length) return;
        
        if(board[row][col] == 'O')board[row][col] = '*';
        
        
        if(row+1 < board.length && board[row+1][col] == 'O')dfs(board,row+1,col);
            
        
        if(col+1 < board[0].length && board[row][col+1]== 'O')dfs(board,row,col+1);
        
        if(row-1 >=0 && board[row-1][col]=='O')dfs(board,row-1,col);
            
        if(col-1 >=0 &&  board[row][col-1]== 'O')dfs(board,row,col-1);
        
    
    }
}