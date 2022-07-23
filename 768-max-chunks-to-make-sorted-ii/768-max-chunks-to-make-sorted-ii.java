class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] lmin = new int[arr.length];
        int currMin = Integer.MAX_VALUE;
        for(int i=arr.length-1;i>=0;i--){
            if(i== arr.length-1){
                lmin[i]=arr[i];
                currMin = arr[i];
            }
            if(arr[i]<currMin){
                currMin = arr[i];
            }
            
            lmin[i]=currMin;
        }
        int currMin2 = Integer.MIN_VALUE;
        int res=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>currMin2){
                currMin2=arr[i];
            }
            
            if(currMin2<=lmin[i+1]){
                res++;
                
            }
        }
        return res+1;
    }
}