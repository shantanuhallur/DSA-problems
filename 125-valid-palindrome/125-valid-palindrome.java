class Solution {
    public boolean isPalindrome(String s) {
        //remove useless characters;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sb.append(ch);
            }
        }
        
        //uppercase to lowercase
        for(int i=0;i<sb.length();i++){
            char ch = sb.charAt(i);
            if(Character.isUpperCase(ch)){
                ch = Character.toLowerCase(ch);
                sb.setCharAt(i,ch);
            }
        }
        
        //check palindrome
        int st = 0;
        int e = sb.length()-1;
        while(st<e){
            if(sb.charAt(st)!=sb.charAt(e)){
                return false;
            }
            st++;
            e--;
        }
        
        return true;
    }
}