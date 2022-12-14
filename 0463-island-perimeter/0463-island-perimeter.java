class Solution {
    public int islandPerimeter(int[][] grid,int[][] dir) {
        int noOfIslands=0;
        int totalNeighbours = 0;
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                    if(grid[i][j] == 1) {
                        noOfIslands++; //counting 1 islands.
                        for(int d = 0;d<dir.length;d++) {
                        int nrow = i + dir[d][0];
                        int ncol = j + dir[d][1];
                        if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1) {
                            totalNeighbours++;
                        } 
                    }
                }
            }
        }
        return ((noOfIslands*4)-totalNeighbours);
    
    }
    public int islandPerimeter(int[][] grid) {
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        return islandPerimeter(grid,dir);
    }
}