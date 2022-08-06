class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int lo = 1; //1 banana 
        int hi = 0;
        for(int pile:piles){
            hi = Math.max(hi,pile);
        }
        
        while(lo<hi){
            int alsp = (lo+hi)/2;
           
            int totalTime =0;
            for(int pile : piles){
                int time = (pile + alsp - 1)/alsp;   //Ceil Value of Time eg:- 7/3 = 3 (7+3-1)/3
                totalTime += time;
            }
            
            if(totalTime > h){
                lo = alsp+1;
            }
            else{
                hi = alsp;
            }
        }
       
        
        return lo;
    }
}