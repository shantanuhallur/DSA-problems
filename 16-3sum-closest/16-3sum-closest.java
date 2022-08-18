class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++){
            int p1 = i;
            int p2 = i+1; // starting pointer
            int p3 = nums.length-1;
            
            while(p2<p3){
                int sum = nums[p1]+nums[p2]+nums[p3];
                
                if(sum<target){
                    p2++;
                }
                else{
                    p3--;
                }
                if(Math.abs(res-target)>Math.abs(sum-target)){
                  res = sum;  
                }
            }
        }
        return res;
    }
}