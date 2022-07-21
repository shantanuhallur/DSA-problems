class Solution {
    public int maxDistToClosest(int[] seats) {
        int j = -1, res = 0; int n = seats.length;
        
        for(int i=0;i<n;i++){
            if(seats[i]==1){
                int ans=0;
                if(j<0){
                    //j still -1 so distance = i
                    ans = i;
                }
                else{
                    // j already set to first 1
                    ans = (i-j)/2;
                }
                res = Math.max(res,ans);
                j=i;
            }
        }
        
        //Case for distance between last 1 and end of the length:- 10000
        res = Math.max(res,n-1-j); //j will be set as it is guarenteed atleast one 1 will appear
        
        return res;
    }
}