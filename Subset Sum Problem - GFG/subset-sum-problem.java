//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean[][] val;
    static int[][] dp;
    static Boolean getAns(int[] arr, int n, int sum) {
        if(n==0 ||sum==0) {
            if(n==0 && sum==0) {
                dp[n][sum] = 1;
                return val[n][sum] = true;
            }
            else if(n==0) {
                dp[n][sum] = 1;
                return val[n][sum] = false;
            }
            else {
                dp[n][sum] = 1;
                return val[n][sum] = true;
            }
        }
        
        if(dp[n][sum]!=-1) return val[n][sum];
        
        if(arr[n-1] <=sum) {
            val[n][sum] = getAns(arr,n-1,sum-arr[n-1]) || getAns(arr,n-1,sum);
            dp[n][sum] = 1;
            return val[n][sum];
        }
        else {
            val[n][sum] = getAns(arr,n-1,sum);
            dp[n][sum] = 1;
            return val[n][sum];
        }
        
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        val = new boolean[N+1][sum+1];
        dp = new int[N+1][sum+1];
        for(int i=0;i<N+1;i++) {
            for(int j=0;j<sum+1;j++) {
                // if(i==0) {
                //     dp[i][j] = 1;
                //     val[i][j] = false;
                // }
                // else{
                //     dp[i][j] = -1;
                // }
                
                // if(j==0) {
                //     dp[i][j] = 1;
                //     val[i][j] = true;
                // }
                // else {
                //     dp[i][j] = -1;
                // }
                dp[i][j] = -1;
            }
        }
        return getAns(arr,N,sum);
    }
}