class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] concat = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> unique_strings = new HashSet<>();
       for(String word:words){
           StringBuilder sb = new StringBuilder();
           
           for(int ch=0;ch<word.length();ch++){
               sb.append(concat[word.charAt(ch)-'a']);
           }
          unique_strings.add(sb.toString());
       }
        return unique_strings.size();
    }
}