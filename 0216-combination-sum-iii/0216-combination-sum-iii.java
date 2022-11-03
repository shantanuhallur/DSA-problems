class Solution {
    public void combinationSum3(int[] coins,int target,int idx,List<Integer> smallAns,List<List<Integer>> ans,int sizeK) {
        if(target == 0 && smallAns.size() == sizeK){
            List<Integer> base = new ArrayList<>(smallAns);
            ans.add(base);
            return;
        }
        
        for(int i = idx;i<coins.length;i++){
            if(target-coins[i]>=0 && smallAns.size()<sizeK){
                smallAns.add(coins[i]);
                combinationSum3(coins,target-coins[i],i+1,smallAns,ans,sizeK);
                smallAns.remove(smallAns.size()-1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] coins = {1,2,3,4,5,6,7,8,9};
        List<Integer> smallAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        combinationSum3(coins,n,0,smallAns,ans,k);
        return ans;
    }
}