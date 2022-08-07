class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int answer = target;
        HashMap<Integer,Integer> map = new HashMap<>();
         int[] ans = new int[2];
        
        for(int i=0;i<nums.length;i++){
            
            if(map.containsKey(nums[i])){
               
                ans[0] = map.get(nums[i]);
                ans[1] = i;
                break;
            }
            
            
            int diff = answer - nums[i];
            map.put(diff,i);
        }
        
        return ans;
    }
}