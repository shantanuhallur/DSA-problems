class Solution {
    public int countCharacters(String[] words, String chars) {
        int ans=0;
        int[] chars_freq = new int[26];
        for(char ch:chars.toCharArray()){
            chars_freq[ch-'a']++;
        }
        
        for(String word:words){
            int word_length=0;
            boolean isGood=true;
            int[] word_char_freq = new int[26];
           for(char ch:word.toCharArray()){
               word_length++;
               word_char_freq[ch-'a']++;
           }
            
            for(int i=0;i<26;i++){
                if(word_char_freq[i]>0){
                    if(word_char_freq[i]>chars_freq[i]){
                        isGood=false;
                    }
                }
            }
            if(isGood){
                ans += word_length;
            }
        }
        return ans;
    }
}