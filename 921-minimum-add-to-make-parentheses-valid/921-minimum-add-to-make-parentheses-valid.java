class Solution {
    public int minAddToMakeValid(String s) {
        int opening =0;
        int correction=0;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
       //CHECK ALL SUBMISSIONS THIS ONE IS MOST OPTIMAL
           if(opening>0 && s.charAt(i)==')'){
               opening--;
               continue;
           }
        else if(s.charAt(i)=='('){
               opening++;
           }
            else{
                correction++;
            }    
        }
        return opening+correction;
    }
}