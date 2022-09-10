class Solution {
     int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int area=1;
                    area = dfs(grid,i,j,area);
                     maxArea = Math.max(maxArea,area);
                    count=0;
                }
            }
        }
        return maxArea==Integer.MIN_VALUE?0:maxArea;
    }
    
    public int dfs(int[][]grid,int i,int j,int area){
        if(i<0 || j<0 || i>= grid.length || j>= grid[0].length)return 0;
        
        grid[i][j]=0;
        count++;
         System.out.print(count);
            if(i<grid.length-1 &&grid[i+1][j]==1)
              dfs(grid,i+1,j,area+1);
            
            if(i> 0 && grid[i-1][j]==1)
                dfs(grid,i-1,j,area+1);
                
            if(j<grid[0].length-1 &&grid[i][j+1]==1)
                dfs(grid,i,j+1,area+1);
                
            if(j> 0 && grid[i][j-1]==1)
                  dfs(grid,i,j-1,area+1);
        
        return count;
    }
}