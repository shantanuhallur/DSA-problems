class Solution {
    public int maxDistToClosest(int[] seats) {
        int j = -1, res = 0; int n = seats.length;
        
        for(int i=0;i<n;i++){
            int ans =0;
            if(seats[i]==1){
                ans = j<0?i:(i-j)/2;
                j=i;
            }
            res = Math.max(ans,res);
        }
        
        res = Math.max(res,n-1-j);
        
        return res;
    }
}