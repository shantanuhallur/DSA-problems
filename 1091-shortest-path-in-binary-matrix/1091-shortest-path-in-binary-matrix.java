class Solution {
    public class locPair{
        int row =0;
        int col =0;
        int dist =0;
        locPair(int row,int col,int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int shortestPathBinaryMatrix_01(int[][] grid,int row,int col,int[][] dir) {
        LinkedList<locPair> que = new LinkedList<>();
        que.addLast(new locPair(row,col,1));
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        while(que.size()>0) {
            int size = que.size();
            while(size-->0) {
                locPair myLoc = que.removeFirst();
                if(myLoc.row == n-1 && myLoc.col == n-1) {
                    return myLoc.dist;
                }
                for(int d=0;d<dir.length;d++) {
                    int nrow = myLoc.row + dir[d][0];
                    int ncol = myLoc.col + dir[d][1];
                    if(nrow>=0 && ncol>=0 && nrow<n && ncol<n && !vis[nrow][ncol] && grid[nrow][ncol] == 0){
                        vis[nrow][ncol]=  true;
                        que.addLast(new locPair(nrow,ncol,myLoc.dist+1));
                    }
                }
            }
        }
        return -1;
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 },                           { -1, -1 } };
        return shortestPathBinaryMatrix_01(grid,0,0,dir);
    }
}