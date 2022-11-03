class Solution {
    public void permuteUnique(int[] nums,int numsUsed,List<Integer> smallAns,List<List<Integer>> ans) {
        if(numsUsed == nums.length){
            List<Integer> base = new ArrayList<>(smallAns);
            ans.add(base);
            return;
        }
        int prev = -1;
        for(int i=0;i<nums.length;i++){
            if(prev!=-1 && nums[i]==nums[prev]) continue;
            if(nums[i]!=-11) {
                int val = nums[i];
                nums[i] = -11;
                smallAns.add(val);
                permuteUnique(nums,numsUsed+1,smallAns,ans);
                smallAns.remove(smallAns.size()-1);
                nums[i] = val;
                prev = i;   
            }
        }
        
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        Arrays.sort(nums);
        permuteUnique(nums,0,smallAns,ans);
        return ans;
    }
}