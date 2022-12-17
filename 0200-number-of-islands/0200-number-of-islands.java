class Solution {
    public static int[] par;
    public static int findPar(int u) {
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }   
        public static int unionFind(char[][] grid,int i,int j,int[][] dir,int n,int m) {
        int cost = 0;
        for(int d=0;d<dir.length;d++) {
            int nrow = i + dir[d][0];
            int ncol = j + dir[d][1];
            if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && grid[nrow][ncol] == '1'){
                int p1 = findPar(i*m +j);
                int p2 = findPar(nrow*m + ncol);
                
                if(p1 != p2) {
                    par[p1] = p2;
                    cost++;
                }
            }
        }
        return cost;
    }
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = {{0,-1},{1,0}};
        par = new int[n*m];
        for(int i=0;i<n*m;i++) {
                par[i]= i;   
            }
        
        int Ones = 0;
        int merges = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]=='1'){
                    merges += unionFind(grid,i,j,dir,n,m);
                    Ones++;
                }
            }
        }
        System.out.print(Ones  + " " + merges);
        return Ones-merges;
    }
}