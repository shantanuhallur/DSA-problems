class Solution {
    int gcd(int a, int b){
        if (b == 0){
            return a;
        }

        return gcd(b,a%b);
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