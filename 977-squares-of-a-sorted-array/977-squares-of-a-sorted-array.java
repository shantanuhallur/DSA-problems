class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int s = 0;
        int l = nums.length-1;
        int k = nums.length-1;
        while(k>=0){
            if(Math.abs(nums[s])>Math.abs(nums[l])){
                res[k]= nums[s]*nums[s];
                s++;
            }
            else{
                res[k]= nums[l]*nums[l];
                l--;
            }
            k--;
        }
        
        return res;
    }
}