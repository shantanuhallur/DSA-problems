class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        for(int num:nums1)seen.add(num);
        
        for(int num:nums2){
            if(seen.contains(num))intersection.add(num);
        }
        
        int[] ans = new int[intersection.size()];
        int i=0;
        for(int num : intersection){
            ans[i] = num;
            i++;
        }
        
        return ans;
    }
}