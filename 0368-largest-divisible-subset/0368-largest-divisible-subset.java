class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
            int dp[] =   new int[nums.length];
        int prev[] =  new int[nums.length];
        Arrays.sort(nums);
        int maxlen = 0,end = 0, n =  nums.length;
        for(int i=0;i<n;i++){ //traverse over elements
            int count  =  1;
            int previdx = -1;
            for(int j=0;j<i;j++){ //inclusion of an element
                if(nums[i]%nums[j]==0 && dp[j]+1>count ){
                    count =  dp[j]+1;
                    previdx = j;                    
                }
            }
            dp[i] = count;
            prev[i] = previdx;
            
            if(dp[i]>maxlen){
                maxlen =  dp[i];
                end =  i;
            }                        
        }
        ArrayList<Integer> ans =  new ArrayList<Integer>();
        while(end!=-1){
            ans.add(nums[end]);
            end =  prev[end];
        }
        
        return ans;
        }
    }
