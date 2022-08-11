class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1;
        int hi = m*n;
        int reqLess = k;
        
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            int actualLess = 0;
            int j = n;
            
            for(int i=1;i<=m;i++){
                while(j>=1 && i*j>mid){
                    j--;
                }
                // one three ja one two ja one one ja two three ja two two ja two one ja and so on.
                // i == 1->m j == ja one one ja one two ja --> so nos before ja = ja one tow ja = two nos.
                actualLess += j;
            }
            
            if(actualLess<reqLess){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        return lo;
    }
}