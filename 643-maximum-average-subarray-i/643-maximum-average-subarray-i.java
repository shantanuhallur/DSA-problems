class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        double ans = Integer.MIN_VALUE;
        //SLIDING WINDOW BABY !!!
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i==k-1) ans = Math.max(ans,sum);
            else if(i>k-1){
                sum -= nums[i-k];
                ans = Math.max(ans,sum);
            }
        }
        ans = ans/k;
        
        return ans;
    }
}