class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        int s1 = 0;int s2 = 0;
        while(s1<name.length() && s2<typed.length()){
            if(name.charAt(s1) == typed.charAt(s2)){
                s1++;
                s2++;
            }
            else if(s1!=0 && typed.charAt(s2)==name.charAt(s1-1)){
                s2++;
            }
            else{
                return false;
            }
        }
         while(s2<typed.length()){
             if(typed.charAt(s2)==name.charAt(s1-1)){
                 s2++;
             }
             else{
                 return false;
             }
         }
        
        return (s1<name.length() ? false : true);
    }
}