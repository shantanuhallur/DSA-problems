class Solution {
    
    private static boolean isMatching(String word,String pattern){
        
            HashMap<Character,Character>map = new HashMap<>();
        
        //Set is necessary because a letter can be mapped to same character twice 
            HashSet<Character>set = new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            char wChar = word.charAt(i);
            char pChar = pattern.charAt(i);
            
            if(map.containsKey(pChar)==true){
                if(map.get(pChar)!= wChar)return false;
            }
            else{
                if(set.contains(wChar))return false;
                map.put(pChar,wChar);
                set.add(wChar);
            }
        }
        return true;
    }
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        ArrayList<String> ans = new ArrayList<>();
        
        for(String word:words){
            if(isMatching(word,pattern)){
                ans.add(word);
            }
        }
        return ans;
    }
}