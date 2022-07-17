class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        
        int s=0 , e= nums.length-1;
        
        int lastNo= nums.length-1;
        
        while(lastNo>=0){
            if(Math.abs(nums[s])>Math.abs(nums[e])){
                arr[lastNo] = nums[s] * nums[s];
                s++;
            } 
            else{
                arr[lastNo] = nums[e] * nums[e];
                e--;
            }
            lastNo--;
        }
        
        return arr;
    }
}