class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int x = target;
        int[] ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            
            if(map.containsKey(nums[i])){
                ans[0] = map.get(nums[i]);
                ans[1] = i;
                break;
            }
            
            int difference = x - nums[i];
            map.put(difference,i);
        }
        
        return ans;
    }
}