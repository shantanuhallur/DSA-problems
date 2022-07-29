class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        //First case where FL is before SL | Second case where SL is before FL
            int max = Math.max(maxSubarray(nums,firstLen,secondLen),
                               maxSubarray(nums,secondLen,firstLen));
        return max;
    }
    
    public int maxSubarray(int[] nums, int firstLen, int secondLen){
        //left max sum
        int[] left = new int[nums.length];
        int sum=0;
        for(int i=0;i<left.length;i++){
            sum+=nums[i];
            
            if(i==firstLen-1){
                left[i]=sum;
            }
            else if(i>=firstLen){
                sum -= nums[i-firstLen];
                left[i] = Math.max(sum,left[i-1]);
            }
        }
        //right max sum
        int[] right = new int[nums.length];
        sum=0;
        for(int i=right.length-1;i>=0;i--){
            sum+=nums[i];
            
            if(i==nums.length-secondLen){
                right[i]=sum;
            }
            else if(i<nums.length-secondLen){
                sum -= nums[i+secondLen];
                right[i] = Math.max(sum,right[i+1]);
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=firstLen-1;i<nums.length-secondLen;i++){
            max = Math.max(left[i]+right[i+1],max);
        }
        return max;
    }
}