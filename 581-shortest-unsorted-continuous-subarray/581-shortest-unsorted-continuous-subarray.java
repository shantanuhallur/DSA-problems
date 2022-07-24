class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int e=-1;
        int max = nums[0];
        //Check if any element is lesser than max of left element
        for(int i=0;i<nums.length;i++){
            if(nums[i]<max){
                e=i;
            }
            else{
                max = nums[i];
            }
        }
        //Check if any element is greater than min of left element
        int s=0;
        int min=nums[nums.length-1];
            for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>min){
                s=i;
            }
            else{
                min = nums[i];
            }
        }
        //return e-s if array sorted ... returns (0-1)+1 = 0; 
        return (e-s)+1;
    }
}