class Solution {
    public int maxArea(int[] height) {
       int res =0;
        int area;
        int s = 0;
        int e = height.length-1;
        while(s<e){
            area = Math.min(height[s],height[e]) * (e-s);
            if(height[s]<height[e]){
                s++;
            }
            else{
                e--;
            }
            
           res = Math.max(res,area);
        }
        return res;
    }
}