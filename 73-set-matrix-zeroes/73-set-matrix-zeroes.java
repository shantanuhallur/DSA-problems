class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean row0=false, col0=false;
        //check if any zero in first col...
        for(int i=0;i<n;i++)if(matrix[i][0]==0)col0=true;
        //check if any zero in first row.
        for(int j=0;j<m;j++)if(matrix[0][j]==0)row0=true;
        //setting first row and first col 0 if the row/col other than 0th has zero in it.
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        //setting cols corresponding to 0th row 0;
        for(int i=1;i<n;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<m;j++){
                    matrix[i][j]=0;
                }
            }
        }
        //setting rows corresponding to 0th col 0;
        for(int j=1;j<m;j++){
            if(matrix[0][j]==0){
                for(int i=1;i<n;i++){
                    matrix[i][j]=0;
                }
            }
        }
        //if we have zero in row make all cols in 0th row zero
        if(row0){
            for(int j=0;j<m;j++)matrix[0][j]=0;
        }
        //if we have zero in col make all rows in 0th col zero
        if(col0){
            for(int i=0;i<n;i++)matrix[i][0]=0;
        }
        //if any row except zeroth has zero , it will make all the row zero including the 0th row
        //if any col except zeroth has zero , it will make all the col zero including the 0th col
        //thats why we can store 0s in 0th row and 0th col as they are as it is going to get ovverrided             by the 0s we have found in rows/cols except them.
    }
}