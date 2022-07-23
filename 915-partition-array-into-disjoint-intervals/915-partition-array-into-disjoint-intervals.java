class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int[] rmin = new int[nums.length];
        for(int i=n-1;i>=0;i--){
            min = Math.min(min,nums[i]);
            rmin[i] = min;
        }
        int max = Integer.MIN_VALUE;
        int[] lmax = new int[nums.length];
        for(int i=0;i<=n-1;i++){
            max = Math.max(max,nums[i]);
            lmax[i] = max;
        }
        
        int res=0;
        
        for(int i=0;i<n;i++){
            if(lmax[i]<=rmin[i+1]){
                res=i+1;
                break;
            }
        }
        return res;
    }
}