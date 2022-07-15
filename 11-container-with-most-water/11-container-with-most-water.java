class Solution {
    public int maxArea(int[] height) {
        int res =0;
        int area=0;
        int start = 0;
        int end = height.length-1;
        
        while(start<end){
            
             area = Math.min(height[start],height[end])*(end-start);
            res=Math.max(area,res);
            if(height[start]>height[end]){
                end--;
            }
            else{
                start++;
            }
        }
        
        return res;
    }
}