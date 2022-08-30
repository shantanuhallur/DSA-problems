class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==1)return 1;
        int ans = 0;
      int[]char_count = new int[128];
        for(char ch:s.toCharArray()){
            char_count[ch]++;
        }
        
        for(int val:char_count){
            ans+=val/2*2; //floorconversion for odd numbers;
        }
        if(ans<s.length())ans+=1;
        
        return ans;
    }
}