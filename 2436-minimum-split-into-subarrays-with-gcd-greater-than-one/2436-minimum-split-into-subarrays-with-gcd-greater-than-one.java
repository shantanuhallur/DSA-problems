class Solution {
    int gcd(int a, int b){
        if (a == 0){
            return b;
        }

        return gcd(b%a,a);
    }
    public int minimumSplits(int[] nums) {
        int currgcd = nums[0];
        int split = 1;
        for(int i=0;i<nums.length;i++) {
            if(gcd(currgcd,nums[i])==1) {
                split++;
                currgcd = nums[i];
            }
            else {
                currgcd = gcd(currgcd,nums[i]);
            }
        }
        return split;
    }
}