class Solution {
    
    public void word(String digits,String[] codes,int idx,String psf,List<String> ans){
        if(idx==digits.length()){
            ans.add(psf);
            return;
        }
        
        int value = digits.charAt(idx) - '0';
        String code = codes[value];
        
        for(int i=0;i<code.length();i++){
            word(digits,codes,idx+1,psf+ code.charAt(i),ans);
        }
    }
    
    public List<String> letterCombinations(String digits) {
         String[] codes = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList<>();
        String psf = "";
       
        if(digits.length()==0) return new ArrayList<>();
        else{
             word(digits,codes,0,psf,ans);
        }
        return ans;
       
    }
}