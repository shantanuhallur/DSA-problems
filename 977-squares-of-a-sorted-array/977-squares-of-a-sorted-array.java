class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int[] res = new int[nums.length];
        for(int i=0;i<=nums.length-1;i++){
            res[i]=nums[i]*nums[i];
        }
        
        Arrays.sort(res);
        return res;
    }
}