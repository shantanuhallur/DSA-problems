class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res =0;
        int li =0;
        int ri =nums.length-1;
        
        while(li<ri){
            res+= nums[ri]-nums[li];
            ri--;
            li++;
        }
        
        return res;
    }
}