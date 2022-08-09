class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        
        for(int i=0;i<nums.length;i++){
            
            while(st.size()>0 && nums[i] < st.peek() && n-i-1 >= k-st.size()){
                st.pop();
            }
            
            if(st.size()<k){
                st.push(nums[i]);
            }
        }
        
        int[] ans = new int[k];
        int j=k-1;
        while(j>=0){
            ans[j--] = st.pop();
        }
        return ans;
    }
}