class Solution {
    public void permute(int[] nums,int numbersUsed,List<Integer> smallAns,List<List<Integer>> ans) {
        if(numbersUsed == nums.length){
            List<Integer> base = new ArrayList<>(smallAns);
            ans.add(base);
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] != -69){
                int val = nums[i];
                nums[i] = -69;
                smallAns.add(val);
                
                permute(nums,numbersUsed+1,smallAns,ans);
                
                smallAns.remove(smallAns.size()-1);    
                nums[i] = val;
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> smallAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums,0,smallAns,ans);
        return ans;
    }
}