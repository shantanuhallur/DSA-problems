class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] ans = new int[m];
        
        for(int col=0;col<m;col++){
            int cpos = col;
            int npos = -1;
            for(int row=0;row<n;row++){
                npos = cpos + grid[row][cpos];
                if(npos<0 || npos >= m || grid[row][cpos] != grid[row][npos]){
                    cpos = -1;
                    break;
                }
                cpos = npos;
            }
            ans[col] = cpos;
        }
        return ans;
    }
}