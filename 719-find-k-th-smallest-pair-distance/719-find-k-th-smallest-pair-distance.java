class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);
        int hi = nums[nums.length-1] - nums[0];
        int lo = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++){
            lo = Math.min(lo,nums[i+1]-nums[i]);
        }
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            
            int count =0;
            int j=0;
            for(int i=0;i<nums.length;i++){
                while(j<nums.length && nums[j]-nums[i]<=mid){
                    j++;
                }
                count += j-i-1;
            }
            
            if(count<k){
                lo = mid+1;
            }
            else{
                hi = mid;
            }
        }
        return lo;
    }
}