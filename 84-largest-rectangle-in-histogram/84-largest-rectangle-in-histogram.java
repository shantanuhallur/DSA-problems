class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxArea=0;
        //ADDED -1 at start and 0 At end of array to handle all cases
        for(int j=0;j<=heights.length;j++){
            int val = j==heights.length?0:heights[j];
            while(st.peek()!=-1 && val<=heights[st.peek()]){
                int rm = j;
                int height = heights[st.pop()];
                int lm = st.peek();
                maxArea = Math.max(maxArea,(rm-lm-1)*height);
            }
            st.push(j);
        }
     
        
        return maxArea;
    }
}