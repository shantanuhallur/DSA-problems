class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sEnd = s.length()-1;
        int tEnd = t.length()-1;
        int sCount=0 , tCount=0;
      while(sEnd>=0 || tEnd>=0){
          while(sEnd>=0){
            if(s.charAt(sEnd)=='#'){
                sEnd--;
                sCount++;
            }
            else if(sCount>0){
                sEnd--;
                sCount--;
            }
            else{
                break;
            }
        }
        
         while(tEnd>=0){
            if(t.charAt(tEnd)=='#'){
                tEnd--;
                tCount++;
            }
            else if(tCount>0){
                tEnd--;
                tCount--;
            }
             else{
                 break;
             }
        }
          if(sEnd>=0 && tEnd >=0 && s.charAt(sEnd)!=t.charAt(tEnd)){
              return false;
          }
          //lengths of string is different
          if((sEnd>=0)!=(tEnd>=0)){
              return false;
          }
          sEnd--;
          tEnd--;
      }  
        return true;
    }
}