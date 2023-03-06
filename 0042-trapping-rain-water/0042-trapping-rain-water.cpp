class Solution {
public:
    int trap(vector<int>& height) {
        //leftMax
        vector<int> left(height.size(),0);
        for(int i=0;i<left.size();i++){
            if(i==0){
                left[i] = height[i];
            }
            else{
                left[i] = max(height[i],left[i-1]);    
            } 
        }
        
        //rightMax
        vector<int> right(height.size(),0);
        for(int i=right.size()-1;i>=0;i--){
            if(i==right.size()-1){
                right[i] = height[i];
            }
            else{
                right[i] = max(height[i],right[i+1]);    
            }
        }
        
        int water=0;
        
        for(int i=0;i<height.size();i++){
            water += min(left[i],right[i]) - height[i];
        }
        
        return water;
    }
};