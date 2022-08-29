class Solution {
    public int fib(int n) {
        
        int[] arr = new int[n+1];
        
        for(int i=0 ; i <= n ; i++){
            if(i==0 || i==1){
                arr[i] = i;
                continue;
            }
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}