class Solution {
    public void sortColors(int[] nums) {
        int start =0;
        int idx = 0;
        int end = nums.length-1;
        
        while(idx<=end && start<=end){ //endth element is unknown can be 0 so we need to swap it to start's index so we need to travel idx till end;
            if(nums[idx]==0){
                nums[idx] = nums[start];
                nums[start] = 0;
                start++;
                idx++;
            }
            else if(nums[idx]==2){
                nums[idx]= nums[end];
                nums[end] = 2;
                end--;
            }
            else{
                idx++;
            }
        }
    }
}