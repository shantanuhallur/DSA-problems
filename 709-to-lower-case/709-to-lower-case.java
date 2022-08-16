class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(Character.isUpperCase(ch)){
                sb.append((char)(ch+32));
            }
            else{
                sb.append(ch);
            }
        }
        return String.valueOf(sb);
    }
}