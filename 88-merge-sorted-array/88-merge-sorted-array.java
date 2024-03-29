class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = nums1.length-1;
        int i = m-1;
        int j = n-1;
        
        while(i>=0 && j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[k] = nums1[i];
                k--;
                i--;
            }
            else{
                 nums1[k] = nums2[j];
                 k--;
                 j--;
            }
        }
        //either i or j will already be 0 because of the while loop.
        while(i>=0){
            nums1[k--] = nums1[i--];
        }
        
        while(j>=0){
            nums1[k--] = nums2[j--];
        }
        
        
    }
}