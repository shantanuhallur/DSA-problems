class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[]nge = new int[nums2.length];
        Stack<Integer>st = new Stack<>();
        st.push(nums2.length-1);
        nge[nums2.length-1] = -1;
        
        for(int i=nums2.length-2;i>=0;i--){
            int val = nums2[i];
            while(st.size()>0 && val>=nums2[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                nge[i] = -1;
            }
            else{
                nge[i] = st.peek();
            }
            st.push(i);
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            if(nge[i]>0){
                map.put(nums2[i],nums2[nge[i]]);
            }
            else{
                map.put(nums2[i],-1);
            }
        }
        
        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            
            ans[i] = map.get(nums1[i]);
        }
        
        return ans;
    }
}