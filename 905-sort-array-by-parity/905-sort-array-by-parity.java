class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int s = 0;
        int e = 0;
        
        while(e<nums.length){
            if(nums[e]%2==0){
                swap(nums,s,e);
                s++;
            }
            e++;
        }
        return nums;
    }
    void swap(int[] nums,int s,int e){
        int temp = nums[s];
        nums[s]=nums[e];
        nums[e]=temp;
    }
}