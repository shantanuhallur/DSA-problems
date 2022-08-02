class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for(int i= nums.length-2;i>=0;i--){
            int val = nums[i];
            while(st.size()>0 && val>=st.peek())st.pop();
            st.push(val);
        }
        
        int[] ans = new int[nums.length];
        
        for(int i= nums.length-1;i>=0;i--){
            int val = nums[i];
            while(st.size()>0 && val>=st.peek())st.pop();
            if(st.size()==0){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek();
            }
            st.push(val);
        }
        
        return ans;
    }
}