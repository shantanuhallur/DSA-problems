class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod =nums[0];
        int[] lArr = new int[nums.length];
        int[] rArr = new int[nums.length];
        int[] arr = new int[nums.length];
        lArr[0]= nums[0];
        for(int i=1;i<nums.length;i++){
            lArr[i]=prod*nums[i];
            prod *= nums[i];
        }
        
        prod =nums[nums.length-1];
        rArr[nums.length-1]= nums[nums.length-1];;
        for(int i=nums.length-2;i>=0;i--){
            rArr[i]=prod*nums[i];
            prod *= nums[i];
        }
        
        arr[0]= rArr[1];
        arr[nums.length-1]=lArr[nums.length-2];
        for(int i=1;i<nums.length-1;i++){
            arr[i]= lArr[i-1]*rArr[i+1];
        }
        
        return arr;
    }
}