class Solution {
    public int nextGreaterElement(int n) {
     char[] arr = (n+"").toCharArray();
        Integer idx1=null;
        for(int i=arr.length-1;i>0;i--){
            if(arr[i]>arr[i-1]){
                idx1 = i;
                break;
            }
        }
        if(idx1==null){
            return -1;
        }
        
        int j=0;
        for(int i=arr.length-1;i>=idx1;i--){
            if(arr[i]>arr[idx1-1]){
                j=i;
                break;
            }
        }
        swap(arr,idx1-1,j);
        int s = idx1;
        int e = arr.length-1;
        while(s<e){
            swap(arr,s,e);
            s++;
            e--;
        }
        
         
        
        String res = new String(arr);
        long val = Long.parseLong(res);
        
        return(val>Integer.MAX_VALUE?-1:(int)val);
    }
    
    void swap(char[] arr,int s,int e){
        char temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}