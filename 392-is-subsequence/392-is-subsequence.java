class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0)return true;
        if(s.length()>t.length())return false;
        
        int ptr1=0;
        int ptr2=0;
        
        while(ptr2<t.length() && ptr1<s.length()){
            if(s.charAt(ptr1)==t.charAt(ptr2)){
                ptr1++;
                ptr2++;
            }
            else{
                ptr2++;
            }
        }
        if(ptr1==s.length())return true;
        else return false;
    }
}