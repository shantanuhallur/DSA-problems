class Solution {
    public int firstMissingPositive(int[] nums) {
       for(int i=0;i<nums.length;i++){
           if(nums[i]<1 || nums[i]>nums.length){
               nums[i] = nums.length+1;
           }
       }
        
        for(int i=0;i<nums.length;i++){
          int val = Math.abs(nums[i]);
            if(val<=nums.length){
                int index = val-1;
                if(nums[index]>0){  
                    //Or else the index is already set *-1 Once (Repeated element in tht array)
                    nums[index]*=-1;
                    
                }
            }
       }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return nums.length+1;
    }
}