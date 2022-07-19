class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] minfrmR = new int[arr.length];
        
        minfrmR[arr.length-1] = arr[arr.length-1];
        
        int min = minfrmR[arr.length-1];
        
        // for(int i=arr.length-2;i>=0;i--){
        //  minfrmR[i] = Math.min(minfrm[i+1],arr[i]);   
        // }
        
        
        for(int i=arr.length-2;i>=0;i--){
            int val = arr[i];
            if(val<min){
                minfrmR[i] = val;
                min=val;
            }
            else{
                    minfrmR[i] = min;      
               }
        }
        
        int res =0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            
            if(max<=minfrmR[i+1]){
                res++;
            }
        }
        
        return res+1;
    }
}