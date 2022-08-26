class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] max_height_row = new int[row];
        int[] max_height_col = new int[col];
        int max_row=0;
        int max_col=0;
        int answer=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                max_row = Math.max(max_row,grid[i][j]);
            }
            max_height_row[i] = max_row; 
            max_row=0;
        }
        
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                max_col = Math.max(max_col,grid[j][i]);
            }
            max_height_col[i] = max_col; 
            max_col = 0;
        }
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                answer += Math.min(max_height_row[i], max_height_col[j]) -grid[i][j];   
            }
        }
        return answer;
    }
}