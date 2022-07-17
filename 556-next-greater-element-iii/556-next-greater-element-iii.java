class Solution {
    public int nextGreaterElement(int n) {
      char[] arr = (n+"").toCharArray();
        int i = arr.length-1;
        while(i>0){
            if(arr[i-1]<arr[i]){
                break;
            }
            i--;
        }
        
        if(i==0){
            return -1;
        }
        int idx = i-1;
        int j = arr.length-1;
        while(j>idx){
            if(arr[j]>arr[idx]){
                break;
            }
            j--;
        }
        
        swap(arr,idx,j);
        int left = i;
        int right = arr.length-1;
        
        while(left<right){
            swap(arr,left,right);
            left++;
            right--;
        }
        String res = new String(arr);
        long val = Long.parseLong(res);
        
        return(val>Integer.MAX_VALUE? -1 : (int)val);
    }
    
    void swap(char[] arr,int s,int e){
        char temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}