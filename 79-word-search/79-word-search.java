class Solution {
    boolean[][]vis;
    public boolean exist(char[][] board, String word) {
        
        int row = board.length;
        int col = board[0].length;
        vis = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0) && wordFound(i,j,0,word,board)){
                    return true;
                }
            }
        }
        return false;
    }
    
   public boolean wordFound(int i,int j,int idx,String word,char[][]board){
       if(idx==word.length())return true;
       if(i<0 || i>=board.length || j<0 || j >=board[0].length || 
          board[i][j]!= word.charAt(idx) || vis[i][j]==true)return false;
       
       vis[i][j]=true;
       if(wordFound(i+1,j,idx+1,word,board)||
         wordFound(i,j+1,idx+1,word,board)||
         wordFound(i-1,j,idx+1,word,board)||
         wordFound(i,j-1,idx+1,word,board)){
           return true;
       }
       vis[i][j]=false;
       return false;
   }
}