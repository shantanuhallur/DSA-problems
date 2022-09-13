class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        if(nums.length==0)return res;
        getSubsets(nums,0,curr,res);
        return res;
    }
    
    void getSubsets(int[] nums,int idx, ArrayList<Integer> curr,List<List<Integer>> res){
        if(idx==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
       
        
        //include
        curr.add(nums[idx]);
        getSubsets(nums,idx+1,curr,res);
        curr.remove(curr.size()-1);
         //exclude
        getSubsets(nums,idx+1,curr,res);
        
        //can do in both ways but if you include first always backtrack to remove the element, if you dont include first you are good to go.
    }
}