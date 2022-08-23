class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int left = 0;
        int right = row*col-1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            int mid_element = matrix[mid/col][mid%col]; //transformation of row&col
            if(mid_element==target){
                return true;
            }
            else if(mid_element<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return false;
    }
}