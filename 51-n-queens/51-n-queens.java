class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> ans = new ArrayList<>();
        totalNQueens(0,board,ans);
        return ans;
    }
    
     public boolean isSafeToPlace(int[][]board,int r,int col){
            int directions[][] = {{-1,-1},{-1,0},{-1,1}};
        for(int[] dir:directions){
            int ro = r + dir[0];
            int co = col + dir[1];
            
            while(ro>=0 && co>=0 && ro<board.length && co <board[0].length){
                if(board[ro][co]==1){
                    return false;
                } 
                ro+= dir[0];
                co+= dir[1];
            }
        }
        
        return true;
    }
    
    public void giveAns(int[][]board,List<List<String>> ans){
        List<String> listStringAns = new ArrayList<>();
        for(int[] row:board){
            String rowAns="";
            for(int box:row){
                if(box==0){
                    rowAns+=".";
                }
                else{
                    rowAns+="Q";
                }
            }
            listStringAns.add(rowAns);
        }
        ans.add(listStringAns);
    }
    
    public void totalNQueens(int r ,int board[][], List<List<String>> ans){
        if(r==board.length){
           giveAns(board,ans);
        }
        
   
        for(int col=0;col<board[0].length;col++){
            if(isSafeToPlace(board,r,col)){
                board[r][col]=1;
                totalNQueens(r+1,board,ans);
                board[r][col]=0;
            }
            
        }
        
      
    }
    
}