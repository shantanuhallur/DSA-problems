class Solution {
    public int splitArray(int[] nums, int m) {
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        //FJP Lecture of 5th August 2022
        for(int num:nums){
            hi+=num;
            lo = Math.max(lo,num);
        }
        
        while(lo<hi){
            int mid = (lo+hi)/2;
            int limit = mid;
            
            int countPart=1;
            int currPartsum=0;
            for(int num:nums){
                if( currPartsum + num <= limit){
                    currPartsum += num;
                }
                else{
                    currPartsum = num;
                    countPart++;
                }
            }
            
            if(countPart<=m){
                hi = mid;
            }
            else{
                lo = mid+1;
            }
        }
        return lo;
    }
}