class Solution {
    
    public int[] getWordFreq(String word2){
        int[] word2_freq = new int[26];
        for(char ch:word2.toCharArray()){
            word2_freq[ch-'a']++;
        }
        return word2_freq;
    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] word2Max_freq = new int[26];
        for(String word2:words2){
            int[] word2_freq = getWordFreq(word2);
            
            for(int i=0;i<26;i++){
                word2Max_freq[i] = Math.max(word2Max_freq[i],word2_freq[i]);               
            }
        }
        
        for(String word1:words1){
            boolean isSubset = true;
            int[] word1_freq = getWordFreq(word1);
            
            
            for(int i=0;i<26;i++){
                if(word2Max_freq[i]>0){
                    if(word2Max_freq[i]>word1_freq[i]){
                        isSubset = false;
                        break;
                    }
                }
            }
            if(isSubset)ans.add(word1);
        }
        
        
        
        return ans;
    }
}