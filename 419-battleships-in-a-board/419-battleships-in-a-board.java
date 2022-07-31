class Solution {
    public int countBattleships(char[][] board) {
        int ans=0;
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X'){
                     if(i==0 && j==0){
                        ans++;
                     }
                    else if(i==0){
                        if(board[i][j-1]!='X'){
                            ans++;
                        }
                    }
                    else if (j==0){
                        if(board[i-1][j]!='X'){
                            ans++;
                        }
                    }
                    else{
                        if(board[i][j-1]!='X' && board[i-1][j]!='X' ){
                            ans++;
                        }
                    }
                }
               
            }
        }
        return ans;
    }
}