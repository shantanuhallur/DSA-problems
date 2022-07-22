class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] mfreq = new int[60];
        int Pairs = 0;
        for(int i:time){
            int val = i%60; //IMP
            if(val==0){
                Pairs += mfreq[val];
            }
            else{
                //Pairing current number with 60-value section 
                Pairs += mfreq[60-val];
            }
            //track of numbers in that modulo section. Adding current number for future pairs.
            mfreq[val]++;
        }
        
        return Pairs;
        
    }
}