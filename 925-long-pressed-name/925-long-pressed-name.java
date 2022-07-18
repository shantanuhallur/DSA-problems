class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i=0 , j =0;
        while(i<name.length() && j < typed.length()){
          if(name.charAt(i)==typed.charAt(j)){
              i++;
              j++;
          }
          else if(i!=0 && typed.charAt(j)==name.charAt(i-1)){
              j++;
          }
            else{
                return false;
            }
        }
        
        while(j< typed.length()){
            if(typed.charAt(j)==name.charAt(i-1)){
                j++;
            }
            else{
                return false;
            }
        }
        
        return (i<name.length() ? false : true);
    }
}