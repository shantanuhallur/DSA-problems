class Solution {
    public int lengthOfLastWord(String s) {
        int j = s.length()-1;
        while(s.charAt(j)==' '){
            j--;
        }
        int ans=0;
        while(j>=0 && s.charAt(j)!=' '){
            j--;
            ans+=1;
        }
        return ans;
    }
}