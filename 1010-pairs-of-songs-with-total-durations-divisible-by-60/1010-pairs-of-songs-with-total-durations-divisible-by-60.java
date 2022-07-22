class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] freq = new int[60];
        int ans=0;
        for(int t:time){
            int val = t%60;
            
            if(val==0){
                ans += freq[val];
            }
            else{
                ans += freq[60-val];
            }
            freq[val]++;
        }
        return ans;
    }
}