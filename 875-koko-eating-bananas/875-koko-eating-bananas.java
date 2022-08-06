class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int loAllowedSpeed = 1; //1 banana 
        int highAllowedSpeed = 0;
        
        for(int pile:piles){
            highAllowedSpeed = Math.max(highAllowedSpeed,pile);
        }
        
        while(loAllowedSpeed < highAllowedSpeed){
            int allowedSpeed = (loAllowedSpeed + highAllowedSpeed)/2;
            
            //calculate hours for this speed
            int totalTime = 0;
            for(int pile:piles){
                int time = (pile + allowedSpeed -1)/allowedSpeed;
                totalTime += time;
            }
            
            if(totalTime>h){
                loAllowedSpeed = allowedSpeed +1;
            }
            else{
                highAllowedSpeed = allowedSpeed;
            }
        }
        
        return loAllowedSpeed;
    }
}