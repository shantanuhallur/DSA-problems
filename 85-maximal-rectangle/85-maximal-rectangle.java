class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        //Maximum area for 0th row
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[0][j]=='1'){
                heights[j]=1; 
            }
        }
        int area = largestRectangleArea(heights);
        //Maximum area for rows from 1st to last.
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;   
                }
                else{
                    heights[j]=0; //if its not 1 then new height = 0 as the link of 1s break the height.which do not form a rectangle
                }
            }
            area = Math.max(area,largestRectangleArea(heights));
        }
        
        return area;
    }
    
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