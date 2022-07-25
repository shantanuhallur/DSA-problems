class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int e = nums.length-1;
        int i = 1;
        int[] ans = new int[nums.length];
        while(i<=nums.length-1){
            ans[i] = nums[e];
            e--;
            i+=2;
        }
        
        i =0;
        while(i<=nums.length-1){
            ans[i] = nums[e];
            e--;
            i+=2;
        }
       
        for(int j=0;j<nums.length;j++){
            nums[j] = ans[j];
        }
    }
}