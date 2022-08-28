
class Solution {
    public String toGoatLatin(String sentence) {
        HashSet<Character> vowels = new HashSet<>();
        for(char ch:"aeiouAEIOU".toCharArray()){
            vowels.add(ch);
        }
        int count = 1;
        StringBuilder sb = new StringBuilder();
        
        for(String word:sentence.split("\\s")){
            if(vowels.contains(word.charAt(0))){
                sb.append(word+"ma");
            }
            else{
                char ch = word.charAt(0);
                word = word.substring(1);
                sb.append(word+ch+"ma");
            }
            
            for(int i=0;i<count;i++){
                sb.append("a");
            }
            count++;
            
            sb.append(" ");
        }
        String ans = sb.substring(0,sb.length()-1);
        
        return ans;
    }
}