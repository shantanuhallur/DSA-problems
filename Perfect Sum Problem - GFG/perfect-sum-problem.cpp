//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{

	int t[1001][1001];
    int mod = 1e9 + 7;
public:
    int subsetSum(int arr[], int n, int sum) {
        if(n==0 && sum==0) return 1;
        if(n==0) return 0;
        
        if(t[n][sum] != -1) return t[n][sum];
        
        if(arr[n-1] <= sum) {
            return t[n][sum] = (subsetSum(arr, n-1, sum-arr[n-1]) + subsetSum(arr, n-1, sum))%mod;
        }
        else {
            return t[n][sum] = subsetSum(arr, n-1, sum);
        }
    }
    
    int perfectSum(int arr[], int n, int sum) {
	    memset(t, -1, sizeof(t));
            return subsetSum(arr, n, sum);
    }
	  
};

//{ Driver Code Starts.
int main() 
{
   	
   
   	int t;
    cin >> t;
    while (t--)
    {
        int n, sum;

        cin >> n >> sum;

        int a[n];
        for(int i = 0; i < n; i++)
        	cin >> a[i];

       

	    Solution ob;
	    cout << ob.perfectSum(a, n, sum) << "\n";
	     
    }
    return 0;
}

// } Driver Code Ends