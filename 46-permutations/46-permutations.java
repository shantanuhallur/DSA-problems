class Solution {
    public int permute1(int idx,int[] nums,List<List<Integer>> ans,List<Integer> sAns) {
        if(idx==nums.length){
            ArrayList<Integer> base = new ArrayList<>(sAns);
            ans.add(base);
            return 1;
        }
      int  count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>-11){
                int val = nums[i];
                nums[i]=-11;
                sAns.add(val);

              count+=  permute1(idx+1,nums,ans,sAns);

                nums[i]=val;
                sAns.remove(sAns.size()-1);
            }
        }
        return count;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sAns = new ArrayList<>();
        
         permute1(0,nums,ans,sAns);
        return ans;
    }
}