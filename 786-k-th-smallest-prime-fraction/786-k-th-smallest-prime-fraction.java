class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double hi = 1.0;
        double lo = 0;
        int req = k;
        //FJP DSA Lecture of 9th August 2022
        while(lo<=hi){
            double mid = (lo+hi)/2;
            int p=0;
            int q=1;
            
            int actual =0;
            int j = 0;
            for(int i=0;i<arr.length;i++){
                while(j<arr.length && arr[i]>mid*arr[j]){
                    j++;
                }
                
                if(j==arr.length){
                    break;
                }
                actual += (arr.length -j);
                
                if(arr[i]*q > p*arr[j]){
                    p = arr[i];
                    q = arr[j];
                }
                
            }
            if(actual<k){
                lo = mid;
            }
            else if(actual>k){
                hi = mid;
            }
            else{
                return new int[] {p,q};
            }
        }
        return null;
    }
}