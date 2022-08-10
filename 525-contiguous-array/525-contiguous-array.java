class Solution {
    public int findMaxLength(int[] nums) {
        int ans =0;
        HashMap<Integer,Integer> map = new HashMap<>(); // SUM --> INDEX
        map.put(0,-1);
        int sum = 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                sum+=-1;
            }
            else{
                sum+=1;
            }
            
            if(map.containsKey(sum)){
                int idx = map.get(sum);
                int length = i - idx;
                if(length > ans){
                    ans = length;
                }
            }
            else{
                map.put(sum,i);
            }
        }
        
        
        
        return ans;
    }
}