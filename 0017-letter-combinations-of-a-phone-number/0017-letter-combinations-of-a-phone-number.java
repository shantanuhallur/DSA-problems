class Solution {
     public void letterCombinations_01(String digits,String psf,int idx,HashMap<Character,String> keys, List<String> res) {
         if(idx==digits.length()){
             res.add(psf);
             return;
         }
         char ch = digits.charAt(idx);
         String key = keys.get(ch);
         for(int i=0;i<key.length();i++){
             letterCombinations_01(digits,psf+key.charAt(i),idx+1,keys,res);
         }
         
     }
    public List<String> letterCombinations(String digits) {
         List<String> res = new ArrayList<>();
        if(digits.length() == 0)return res;
        HashMap<Character,String> keys = new HashMap<>();
        keys.put('2',"abc");
        keys.put('3',"def");
        keys.put('4',"ghi");
        keys.put('5',"jkl");
        keys.put('6',"mno");
        keys.put('7',"pqrs");
        keys.put('8',"tuv");
        keys.put('9',"wxyz");
       
        letterCombinations_01(digits,"",0,keys,res);
        return res;
    }
}