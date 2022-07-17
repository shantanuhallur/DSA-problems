class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        if(k<0){
            k=k+nums.length;
        }
        //part1
      reverse(nums,0,nums.length-k-1);
        //part2
      reverse(nums,nums.length-k,nums.length-1);
        //whole
        reverse(nums,0,nums.length-1);
    }
    void reverse(int[] arr,int s,int e){
        int li = s;
        int ri = e; 
        while(li<ri){
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;
            
            li++;
            ri--;
        }    
    }
}