class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] concat = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> unique_strings = new HashSet<>();
       for(String word:words){
           StringBuilder sb = new StringBuilder();
           
           for(char ch:word.toCharArray()){
               sb.append(concat[ch-'a']);
           }
          unique_strings.add(sb.toString());
       }
        return unique_strings.size();
    }
}