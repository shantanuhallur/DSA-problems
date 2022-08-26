class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        
        int[] max_height_row = new int[n];
        int[] max_height_col = new int[n];
        int answer=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                 max_height_row[i] = Math.max(max_height_row[i],grid[i][j]);
                 max_height_col[j] = Math.max(max_height_col[j],grid[i][j]);
            }
           
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                answer += Math.min(max_height_row[i], max_height_col[j]) -grid[i][j];   
            }
        }
        return answer;
    }
}