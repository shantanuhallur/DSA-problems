class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lowestMaxCapacity =Integer.MIN_VALUE;
        int maxCapacity = 0;
        
        for(int wt : weights){
            lowestMaxCapacity = Math.max(lowestMaxCapacity,wt);
            maxCapacity += wt;
        }
        
        while(lowestMaxCapacity < maxCapacity){
            int limit = (lowestMaxCapacity+maxCapacity)/2;
            int sum=0;
            int reqDays = 1;
            for(int wt:weights){
                if(sum + wt <= limit){
                  sum += wt;  
                }
                else{
                    sum = wt;
                    reqDays++;
                }
            }
            
            if(reqDays>days){
                lowestMaxCapacity = limit+1;
            }
            else{
                maxCapacity = limit;
            }
        }
        
        return maxCapacity;
    }
}