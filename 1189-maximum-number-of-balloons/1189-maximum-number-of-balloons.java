class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] char_counts = new int[26];
        for(char ch:text.toCharArray()){
            if(ch == 'b' ||ch == 'a'|| ch == 'l'||ch == 'o'||ch == 'n' ){
             char_counts[ch-'a']++;
            }
        }
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans,char_counts[0]);//a
        ans = Math.min(ans,char_counts[1]);//b
        ans = Math.min(ans,char_counts[11] /2);//l
        ans = Math.min(ans,char_counts[14] /2);//o
        ans = Math.min(ans,char_counts[13]);//n
        return ans;
    }
}