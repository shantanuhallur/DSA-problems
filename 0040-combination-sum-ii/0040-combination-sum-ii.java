class Solution {
    public void combinationSum2(int[] candidates, int target,int idx,List<Integer> psf ,List<List<Integer>> ans) {
        if(target==0){
            List<Integer> base = new ArrayList<>(psf);
            ans.add(base);
            return;
        }
        
        int prev = -1;
        for(int i = idx; i<candidates.length;i++){
            if(prev != -1 && candidates[prev] == candidates[i])continue;
            if(target - candidates[i]>=0){
                psf.add(candidates[i]);
                combinationSum2(candidates,target-candidates[i],i+1,psf,ans);
                psf.remove(psf.size()-1); //ArrayList is created on Heap , String is created on Stack.
            }
            prev = i;
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //JUST SORT ARRAY FOR THIS UNIQUE TWIST.
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> psf = new ArrayList<>();
        combinationSum2(candidates,target,0,psf,ans);
        return ans;
    }
}