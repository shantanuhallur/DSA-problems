class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxArea=0;
        //ADDED -1 at start and 0 At end of array to handle all cases
        for(int i=0;i<=heights.length;i++){
            int val = i==heights.length?0:heights[i];
            while(st.peek()!= -1 && val <= heights[st.peek()]){
                int rm = i;
                int height = heights[st.pop()];
                int lm = st.peek();
                maxArea = Math.max(maxArea,(rm-lm-1)*height);
            }
            st.push(i);
        }
     
        
        return maxArea;
    }
}