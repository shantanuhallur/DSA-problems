public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            n = (n&(n-1)); //hamming wight where only last set bit is changed to unset bit which means                              we only have to run the loop the number of set bits times.
            count++;
        }
        return count;
    }
}