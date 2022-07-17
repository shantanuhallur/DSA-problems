class Solution {
    public int majorityElement(int[] nums) {
       
        Integer me = nums[0];
        int k=1;
        int count=1;
        while(k<=nums.length-1){
            if(count==0){
                me = nums[k];
                count = 1;
            }
           else if(nums[k]==me){
                count++;
            }
            else {
                count--;
            }
            
            k++;
        }
        
        return me;
    }
}