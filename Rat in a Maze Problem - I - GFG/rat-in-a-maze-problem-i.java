// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
         int[][] dir = {{-1,0}, { 1, 0 }, { 0, -1 }, { 0, 1 } };
         String[] name = { "U", "D", "L","R" };
         ArrayList<String>  ans = new ArrayList<>();
         if(m[0][0]  == 0) return ans;
          mazepaths(0, 0, n-1, n-1, dir, name, "",m,ans);
          return ans;
        
    }
    
    public static void mazepaths(int sr,int sc,int dr,int dc,
    int[][] dir,String[]  name,String psf ,int[][] vis,ArrayList<String> ans){
        if(sr==dr && sc == dc){
           
            
            ans.add(psf);
            return;
        }
        
        vis[sr][sc]=0;
        
        for(int d=0;d<dir.length;d++){
            int r = sr+dir[d][0];
            int c = sc+dir[d][1];
            
            if(r>=0 && r<=dr && c>=0 && c<=dc && vis[r][c]==1 ){

                mazepaths(r,c,dr,dc,dir,name,psf+name[d],vis,ans);
            }
        }
        vis[sr][sc]=1;
        
        
    }
}