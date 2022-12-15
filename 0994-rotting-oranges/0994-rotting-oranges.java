class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length; int m = grid[0].length;
        LinkedList<Integer> que = new LinkedList<>();
        boolean hasRipe = false;
        int[][] dir =  {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<n;i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==2){
                    que.addLast(i*m + j); //1D representation.
                }
                else if(grid[i][j]==1){
                    hasRipe = true;
                }
            }
        }
        
        if(!hasRipe){
            return 0;
        }
        
        int size = que.size();
            while(size --> 0) {
                int rval = que.removeFirst();
                int row = rval/m;
                int col = rval%m;
                
                for(int d=0;d<dir.length;d++) {
                    int nrow = row + dir[d][0];
                    int ncol = col + dir[d][1];
                    
                    if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1){
                        grid[nrow][ncol] = 2;
                        que.addLast(nrow*m + ncol);
                    }
                }
                
            }
        
        
        int time = 0;
        while(que.size()!=0) {
            size = que.size();
            while(size --> 0) {
                int rval = que.removeFirst();
                int row = rval/m;
                int col = rval%m;
                
                for(int d=0;d<dir.length;d++) {
                    int nrow = row + dir[d][0];
                    int ncol = col + dir[d][1];
                    
                    if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1){
                        grid[nrow][ncol] = 2;
                        que.addLast(nrow*m + ncol);
                    }
                }
                
            }
           time++;
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        
        return time;
    }
}