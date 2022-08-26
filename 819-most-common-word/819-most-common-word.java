class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> banned_words = new HashSet<>();
        HashMap<String,Integer> paragraph_words = new HashMap<>();
        
        for(String ban : banned){
            banned_words.add(ban);
        }
        
        String[] words = paragraph.toLowerCase().split("\\W+"); //REGEX
        
        for(String word:words){
            if(!banned_words.contains(word)){
                paragraph_words.put(word,paragraph_words.getOrDefault(word,0)+1);         
            }
        }
        
        int max=0;
        String commonWord = "";
        
       for(String word: paragraph_words.keySet()){
           if(paragraph_words.get(word)>max){
               max = paragraph_words.get(word);
               commonWord = word;
           }
       }
        return commonWord;
    }
}