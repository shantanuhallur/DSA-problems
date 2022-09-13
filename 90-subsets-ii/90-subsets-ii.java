class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0)return res;
        getSubsets(nums,0,new ArrayList<Integer>(),res);
        return res;
    }
    
    void getSubsets(int[] nums,int idx, ArrayList<Integer> output,List<List<Integer>> res){
        if(idx==nums.length){
            if(!res.contains(output))res.add(output);
            return;
        }
        //exclude
        getSubsets(nums,idx+1,new ArrayList<>(output),res);
        //include
        output.add(nums[idx]);
        getSubsets(nums,idx+1,new ArrayList<>(output),res);
    
        
        //can do in both ways but if you include first always backtrack to remove the element, if you dont include first you are good to go.
    }
}