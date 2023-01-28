class Solution {
    /*
    Return Type: index of the search key, if it is contained in the array; otherwise, (-(insertion point) – 1). The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.
    */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        tails[0] = nums[0];
        int len = 1;
        
        for(int i=0;i<n;i++) {
            if(nums[i] > tails[len-1]) {
                tails[len] = nums[i];
                len++;
            }
            else {
                int idx = Arrays.binarySearch(tails,0,len-1,nums[i]);
                if(idx<0) { 
                    idx = -idx; //insertion point of element if not found.
                    idx = idx-1; // overRite the element before insertion pt.
                }
                tails[idx] = nums[i];
            }
        }
        return len;
    }
}