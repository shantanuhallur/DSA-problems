class Solution {
    
    public int dfsMaxArea(int i, int j, int n, int m, int[][] grid, int[][] dir) {
        grid[i][j] = 0;
        int count = 1;
        for (int d = 0; d < dir.length; d++) {
            int nrow = i + dir[d][0];
            int ncol = j + dir[d][1];
            if (nrow >=0 && ncol >=0 && nrow < n && ncol < m && grid[nrow][ncol] == 1) {
                count += dfsMaxArea(nrow, ncol, n, m, grid, dir);
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0; // 0 row || 0 column
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int n = grid.length;
        int m = grid[0].length;
        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    area = Math.max(area,dfsMaxArea(i, j, n, m, grid, dir));
                }
            }
        }
        return area;
    }
}