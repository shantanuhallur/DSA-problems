class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        String res = "";
        for(char ch : s.toCharArray()){
            if(Character.isUpperCase(ch)){
                res = res + (char)(ch+32);
            }
            else{
                res+= ch;
            }
        }
        return res;
    }
}