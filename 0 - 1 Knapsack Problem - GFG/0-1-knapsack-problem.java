//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    static int[][] dp;
    //Function to return max value that can be put in knapsack of capacity W.
    static int getMax(int[] wt, int[] val, int n,int W) {
        if(n==0||W==0) return 0;
        
        if(dp[W][n]!=-1) return dp[W][n];
        
        if(wt[n-1]<=W) {
            dp[W][n] = Math.max(val[n-1] + getMax(wt,val,n-1,W-wt[n-1]),
                                getMax(wt,val,n-1,W));
        }
        else {
            dp[W][n] = getMax(wt,val,n-1,W);    
        }
        return dp[W][n];
    }
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        dp = new int[n+1][W+1];
        // for(int[] row : dp) {
        //     Arrays.fill(row,-1);
        //  }
         
         for(int i=1;i<n+1;i++) {
             for(int j=1;j<W+1;j++) {
                    
                    if(wt[i-1]<=j) {
                        dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]],
                                            dp[i-1][j]);
                    }
                    else {
                        dp[i][j] = dp[i-1][j];    
                    }
             }
         }
         return dp[n][W];
    } 
}


