class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int max = -1;
//As local inversions are subset of global inversions, just find one global inversion which is not a local inversion which will prove that global inver> local inver.
        for(int i=0;i<nums.length-2;i++){
            //max has the highest likelyhood of being bigger than that element of                   index+2 || not index + 1 as else it will bee a local inversion as well.
            max = Math.max(max,nums[i]);
            if(max>nums[i+2])return false;
        }
        return true;
    }
}