class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        //get length of first string
        int length = strs[0].length();
        //check from the length of first string to each string
        for(int i=0;i<strs.length;i++){
            //if next string is small update the current length
                length = Math.min(length,strs[i].length()); 
            
            //form 0 to that length start checking characters one by one of 2 strings
            for(int j=0;j<length;j++){
               char ch1 = strs[0].charAt(j);
               char ch2 = strs[i].charAt(j);
                // if character is found not equal , update that length and move forward with that                        length by breaking
                if(ch1!=ch2){
                    length = j;
                    break;
                }
            }
            
            //keep continuing the checking till last string.
            
        }
        return strs[0].substring(0,length);
    }
}