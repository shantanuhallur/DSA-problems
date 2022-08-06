class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lams = 1;
        int hams = Integer.MIN_VALUE;
        
        for(int size:nums){
            hams = Math.max(hams,size);
        }
        
        while(lams < hams){
            int ams = (lams + hams)/2;
            int operations = 0;
            for(int ball:nums){
                if(ball > ams){
                    int spare = ball - ams; //MOST CRUCIAL PART eg:- 13 balls ams = 2 then spare                                                = 11. and operations = (11 +2-1)/2 = 6 OPERATIONS 
                    int ops = (spare + ams - 1)/ams;
                    operations +=  ops; //MOST CRUCIAL PART
                }
                
            }
            
            if(operations>maxOperations){
                lams = ams+1;
            }
            else{
                hams = ams;
            }
        }
        
        return lams;    
    }
}