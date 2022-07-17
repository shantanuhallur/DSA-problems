class Solution {
    public int majorityElement(int[] nums) {
       
        Integer me = null;
        int count = 0;
        
        for(int i=0;i<=nums.length-1;i++){
            if(count==0){
                me = nums[i];
                count = 1;
            }
            else if(me==nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        return me;
    }
}