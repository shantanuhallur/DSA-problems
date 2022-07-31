class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        double ans = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i==k-1){
                double avg = sum/k;
                // System.out.print("AVG ->"+avg);
                ans = Math.max(ans,avg);
            }
            else if(i>k-1){
                sum -= nums[i-k];
                double avg = sum/k;
                ans = Math.max(ans,avg);
            }
        }
        return ans;
    }
}