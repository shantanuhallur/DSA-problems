class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count =0;
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
            
            if(i==max){
                count++;
            }
        }
        
        return count;
    }
}