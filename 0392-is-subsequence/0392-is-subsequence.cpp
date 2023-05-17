class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0)return true;

        
        int ptr1=0;
        int ptr2=0;
        
        while(ptr2<t.length()){
            if(s.charAt(ptr1)==t.charAt(ptr2)){
                ptr1++;
                
                if(ptr1==s.length())return true;
            }
            
            ptr2++;
            
        }
       return false;
    }
}