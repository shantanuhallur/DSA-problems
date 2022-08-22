class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int e = 0;
        int o = 1;
        int n = nums.length-1;
        while(e<=n && o <= n){
            while(e<=n && nums[e]%2==0){
                e+=2;
            }
            
            while(o<=n && nums[o]%2!=0){
                o+=2;
            }
            if(e<=n && o<=n) swap(e,o,nums); //can go out of bounds if perfect array.
           
        }
        return nums;
    }
    public void swap(int idx1,int idx2,int[] nums){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}