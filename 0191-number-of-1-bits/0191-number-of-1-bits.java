public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        int bitsCount=0; //considering java bit can be added as 1 when right shift and loop goes                               infinite
        while(n!=0 && bitsCount<32){
            int res = (n&1);
            if(res==1)count++;
            n >>= 1;
            bitsCount++; 
        }
        return count;
    }
}