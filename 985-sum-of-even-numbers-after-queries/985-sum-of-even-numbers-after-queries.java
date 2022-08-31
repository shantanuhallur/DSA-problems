class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] output_arr = new int [nums.length];
        int even_sum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                even_sum += nums[i];
            }
        }
        
        for(int i=0;i<queries.length;i++){
            int idx = queries[i][1];
            int val = queries[i][0];
            int no_before_idx = nums[idx];
             nums[idx] += val;
             int no_at_idx = nums[idx];
            if(no_before_idx%2!=0){
                if(no_at_idx%2==0){
                    even_sum += nums[idx];
                }
            }
            else{
                if(no_at_idx%2==0){
                    even_sum += val;
                }
                else{
                     even_sum -= no_before_idx;
                }
            }
           
            
            
            output_arr[i] = even_sum;
        }
        return output_arr;
    }
}