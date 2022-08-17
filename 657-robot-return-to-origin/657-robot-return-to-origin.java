class Solution {
    public boolean judgeCircle(String moves) {
        int r=0,l=0,d=0,u=0;
        
        for(char c :moves.toCharArray()){
            
            if(c=='R')r++;
            if(c=='L')l++;
            if(c=='U')u++;
            if(c=='D')d++;
        }
        
        return(r==l && d==u);
    }
}