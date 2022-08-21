class Solution {
    public String reverseOnlyLetters(String s) {
        char[] str = s.toCharArray();
        int st= 0;
        int e = str.length-1;
        while(st<e){
            while(!Character.isLetter(str[st])){
                st++;
                if(st>=e)break;
            }
            
            while(!Character.isLetter(str[e])){
                e--;
                if(e<=st)break;
            }
            if(st>=e || e<=st)break;
            char temp = str[st];
            str[st] = str[e];
            str[e] = temp;
            st++;
            e--;
        }
        
        return String.valueOf(str);
    }
}