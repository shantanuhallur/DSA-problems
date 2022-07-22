class Solution {
    public int[][] diagonalSort(int[][] mat) {
        HashMap<Integer,PriorityQueue<Integer>>map= new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int gap = i-j;
                
                if(map.containsKey(gap)==false){
                    map.put(gap,new PriorityQueue<>());
                }
                map.get(gap).add(mat[i][j]);
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int gap = i-j;
                
                mat[i][j] = map.get(gap).remove();
            }
        }
        return mat;
    }
}