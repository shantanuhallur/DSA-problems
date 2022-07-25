class Solution {
    public boolean isPalindrome(String s , int st , int e){
        while(st<=e){
            if(s.charAt(st)==s.charAt(e)){
                st++;
                e--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int st = 0 ;
        int e = s.length()-1;
        while(st<=e){
            if(s.charAt(st) != s.charAt(e)){
             return isPalindrome(s,st+1,e)||isPalindrome(s,st,e-1);  
            }
            else if(s.charAt(st)==s.charAt(e)){
                st++;
                e--;
            }
        }
        return true;
    }
}