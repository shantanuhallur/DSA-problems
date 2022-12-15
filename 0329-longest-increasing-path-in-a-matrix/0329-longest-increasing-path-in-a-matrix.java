class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] inDegree = new int[n][m];
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<m;j++) {
                for(int d=0; d<dir.length;d++) {
                    int nrow = i + dir[d][0];
                    int ncol = j + dir[d][1];
                    
                    if(nrow >=0 && ncol >=0 && nrow < n && ncol <m && matrix[nrow][ncol] > matrix[i][j]) {
                            inDegree[nrow][ncol]++;
                    }
                }
            }
        }
            
            LinkedList<Integer> que = new LinkedList<>();
            for(int i = 0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    if(inDegree[i][j]==0)que.addLast(i*m +j);
                }
            }
            int level = 0;
            while(que.size()!=0) {
                int size = que.size();
                while(size-- >0) {
                    int rvtx = que.removeFirst();
                    int r = rvtx/m;
                    int c = rvtx%m;
                    
                    for(int d=0; d<dir.length;d++) {
                    int nrow = r + dir[d][0];
                    int ncol = c + dir[d][1];
                    
                    if(nrow >=0 && ncol >=0 && nrow < n && ncol <m && matrix[nrow][ncol] > matrix[r][c] &&
                      -- inDegree[nrow][ncol] == 0 ) {
                        que.addLast(nrow*m + ncol);
                    }
                }
                }
                level++;
            }
            return level;
        }
    }