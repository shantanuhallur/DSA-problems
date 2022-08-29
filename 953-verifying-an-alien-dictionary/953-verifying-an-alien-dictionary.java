class Solution {
    int[] AlienOrder;
    public boolean isAlienSorted(String[] words, String order) {
        AlienOrder = new int[26];
        
        for(int i=0;i<order.length();i++){
            char ch = order.charAt(i);
            AlienOrder[ch-'a'] = i; 
        }
        
        for(int i=1;i<words.length;i++){
            if(compare(words[i-1],words[i])>0)return false; //+ve value = not sorted.
        }
        return true;
    }
    public int compare(String word1,String word2){
        int i=0;
        int j=0;
        int sameSub_word=0;
        while(i<word1.length() && j <word2.length() && sameSub_word==0){
            // if(word1.charAt(i)!= word2.charAt(j)){
            //     sameSub_word = AlienOrder[word1.charAt(i)-'a'] -                                                        AlienOrder[word2.charAt(j)-'a']; //-ve if sorted +ve                                                                      if not sorted;
            //     return sameSub_word;
            // }
            
            //OR
            sameSub_word = AlienOrder[word1.charAt(i)-'a'] -
                           AlienOrder[word2.charAt(j)-'a'];
            i++;
            j++;
        }
        
        if(sameSub_word==0){
            return word1.length() - word2.length(); //words are sorted = -ve value.
        }
        else{
            return sameSub_word;
        }
    }
}