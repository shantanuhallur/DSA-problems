class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        
        int[] min_freq = new int[26];
        Arrays.fill(min_freq,Integer.MAX_VALUE);
        
        for(String word:words){
            int[] min_char_freq = new int[26];
            
            for(char ch:word.toCharArray()){
                min_char_freq[ch-'a']++;
            }
            
            for(int i=0;i<26;i++){
                min_freq[i] = Math.min(min_freq[i],min_char_freq[i]);                
            }
        }
        
        for(int i=0;i<26;i++){
            while(min_freq[i]>0){
                ans.add("" + (char)(i+'a'));
                min_freq[i]--;
            }
        }
        return ans;
    }
}