class Solution {
    private static final String OPENING_BRACKETS = "({[";
       private static final String CLOSING_BRACKETS = ")}]";
    private boolean isOpeningBracket(char ch){
        return OPENING_BRACKETS.indexOf(ch)!= -1;
    }
    private boolean isMatching(char pop , char ch){ 
        return OPENING_BRACKETS.indexOf(pop)==CLOSING_BRACKETS.indexOf(ch);
    }
    public boolean isValid(String s) {
        Stack<Character>st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
           if(isOpeningBracket(ch)){
               st.push(ch);
           }
            else{
                if(st.isEmpty() || !isMatching(st.pop(),ch)){
                    return false;
                }
            }
        }
        
        return (st.isEmpty());
    }
    
}