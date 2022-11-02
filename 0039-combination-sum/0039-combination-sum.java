class Solution {
    public void combinationSum(int[] candidates, int target,int idx,List<Integer> psf ,List<List<Integer>> ans) {
        if(target==0){
            List<Integer> base = new ArrayList<>(psf);
            ans.add(base);
            return;
        }
        
        for(int i = idx; i<candidates.length;i++){
            if(target - candidates[i]>=0){
                psf.add(candidates[i]);
                combinationSum(candidates,target-candidates[i],i,psf,ans);
                psf.remove(psf.size()-1); //ArrayList is created on Heap , String is created on Stack.
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> ans = new ArrayList<>();
         List<Integer> psf = new ArrayList<>();
         combinationSum(candidates,target,0,psf,ans);
        return ans;
    }
}