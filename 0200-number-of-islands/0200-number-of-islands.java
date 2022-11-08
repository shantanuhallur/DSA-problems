class Solution {
    public void dfs(char[][] grid,boolean[][] boxes,int sr,int sc,int[][] dir) {
        boxes[sr][sc] = true;
        int n = grid.length;
        int m = grid[0].length;
        for(int d=0;d<dir.length;d++){
                int r = sr + dir[d][0];
                int c = sc + dir[d][1];
                if(r>=0 && r<n && c>=0 && c<m && grid[r][c] == '1' && !boxes[r][c]) {
                    boxes[r][c] = true;
                    dfs(grid,boxes,r,c,dir);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][] boxes = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && boxes[i][j] == false){
                    count+=1;
                    dfs(grid,boxes,i,j,dir);
                }
            }
        }
        return count;
    }
}