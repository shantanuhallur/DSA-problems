class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] rarr = new int[nums.length];
        int prod=1;
        //Product from right
        for(int i=nums.length-1;i>=0;i--){
            prod *= nums[i];
            rarr[i] = prod;
        }
        
        //product from left * prod from right =  arr[i]
        int[] arr = new int[nums.length];
        prod = 1;
        for(int i=0;i<nums.length-1;i++){
            arr[i] = prod*rarr[i+1];
            prod*=nums[i];
        }
        arr[nums.length-1]= prod;
        
        return arr;
    }
}