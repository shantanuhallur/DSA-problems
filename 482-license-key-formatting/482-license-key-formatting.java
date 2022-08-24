class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        s = s.replaceAll("-","");
        
        StringBuilder sb = new StringBuilder(s);
         //System.out.println(sb.length());
        for(int i=sb.length()-k;i>0;i=i-k){
           // System.out.print(i);
            sb.insert(i,"-");
        }
        return sb.toString();
    }
}