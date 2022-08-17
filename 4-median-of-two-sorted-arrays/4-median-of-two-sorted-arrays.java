class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int m = nums1.length;
        int n = nums2.length;
        //FJP DSA Lecture of 16th August 2022
      int  m1 = (m+n+1)/2;
      int  m2 = (m+n+2)/2;
        
     int   median1 = getKthElementFromMergedArray(nums1,nums2,m1,0,0);
     int   median2 = getKthElementFromMergedArray(nums1,nums2,m2,0,0);
        
        return (median1+median2)/2.0;
    }
    public int getKthElementFromMergedArray(int[]nums1,int[]nums2,int k,int s1,int s2){
        if(s1>=nums1.length){
            return nums2[s2+k-1];
        }
        if(s2>=nums2.length){
            return nums1[s1+k-1];
        }
        if(k==1){
            return Math.min(nums1[s1],nums2[s2]);
        }
        
        int ele1 = Integer.MAX_VALUE;
        if(s1+ k/2 -1<nums1.length){
            ele1 = nums1[s1+ k/2 -1];
        }
        int ele2 = Integer.MAX_VALUE;
        if(s2+ k/2 -1<nums2.length){
            ele2 = nums2[s2+ k/2 -1];
        }
        if(ele1<ele2){
           return getKthElementFromMergedArray(nums1,nums2,k-k/2,s1+k/2,s2);
        }
        else{
           return getKthElementFromMergedArray(nums1,nums2,k-k/2,s1,s2+k/2);
        }
    }
}