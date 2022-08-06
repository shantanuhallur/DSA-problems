class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo =1;
        int hi = 1000000;
        
        while(lo<hi){
            int divisor = (lo+hi)/2;
            int sum = 0;
            for(int val:nums){
                int quotient = (val+divisor-1)/divisor;
                sum += quotient;
            }
            
            if(sum > threshold){
                lo = divisor+1;
            }
            else{
                hi = divisor;
            }
        }
        
        return lo;
    }
}