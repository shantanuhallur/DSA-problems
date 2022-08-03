class Solution {
    public int scoreOfParentheses(String s) {
        // DONT EVEN PUSH CHARS IN STACK . JUST KEEP SCORE IN STACK AND TRAVERSE THROUGH STRING.
        Stack<Integer> st = new Stack<>();
        
        // ( --> -1
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(-1);
            }
            else{
                if(st.peek()==-1){
                    // Independent String case '()' 
                    st.pop();
                    st.push(1); //score of this case = 1
                }
                else{
                    int sum=0;
                    while(st.peek()!=-1){
                        sum += st.pop();
                    }
                    st.pop();
                    st.push(2*sum);
                }
            }
        }
        // if only A , B strings are present without -1s in stack just positive nos.
        int sum = 0 ;
        while(st.size()>0){
            sum+= st.pop();
        }
        
        return sum;
    }
}