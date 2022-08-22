class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int filler = 0;
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length-1;
        
        while(rowBegin<=rowEnd && colBegin<=colEnd){
            
            for(int i=colBegin;i<=colEnd;i++){
                matrix[rowBegin][i] = ++filler;
            }
            rowBegin++;
            
            for(int i=rowBegin ; i<=rowEnd ; i++){
                matrix[i][colEnd] = ++filler;
            }
            colEnd--;
            
            for(int i=colEnd ; i>=colBegin ; i--){
                matrix[rowEnd][i] = ++filler;
            }
            rowEnd--;
            
            for(int i=rowEnd ; i>=rowBegin ; i--){
                matrix[i][colBegin] = ++filler;
            }
            colBegin++;
        }
        
        return matrix;
    }
}