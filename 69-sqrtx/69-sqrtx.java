class Solution {
    public int mySqrt(int x) {
        long lo=0;
        long hi = (x/2) + 1;
        
        while(lo<hi){
            long mid = lo + (hi-lo)/2+1; 
            long square = mid*mid;
            
            if(square == x){
                return (int)mid;
            }
            else if(square < x){
                lo = mid;
            }
            else{
                hi = mid-1;
            }
        } 
        return (int)lo;
    }
}