class Solution {
    
    public int permute_01(int[] nums,int idx,List<List<Integer>> ans,List<Integer> smallAns) {
        if(idx==nums.length) {
            List<Integer> baseAns = new ArrayList<>(smallAns);
            ans.add(baseAns);
            return 1;
        }
        int count = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != -11) {
                int val = nums[i];
                nums[i] = -11;
                smallAns.add(val);
                
                count += permute_01(nums,idx+1,ans,smallAns);
                
                smallAns.remove(smallAns.size()-1);
                nums[i] = val;
            }
        }
        
        return count;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        
        permute_01(nums,0,ans,smallAns);
        
        return ans;
    }
}