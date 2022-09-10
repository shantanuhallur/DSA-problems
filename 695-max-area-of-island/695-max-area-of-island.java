class Solution {
     int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        boolean[][] vis = new boolean[n][m]; // This is used since we should not modify the original data.                                                          Otherwise,
                                             // we would have to make changes in the original grid array.

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] != 0) {
                    int area = dfs_maxAreaOfIsland(grid, vis, dir, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
    
   public static int dfs_maxAreaOfIsland(int[][] grid, boolean[][] vis, int[][] dir, int sr, int sc) {

        vis[sr][sc] = true;

        int count = 0;

        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= grid.length - 1 && c <= grid[0].length - 1 && grid[r][c] != 0
                    && !vis[r][c]) {
                count += dfs_maxAreaOfIsland(grid, vis, dir, r, c);
            }
        }

        return count + 1;
    }
}