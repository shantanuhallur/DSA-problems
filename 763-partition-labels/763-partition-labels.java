class Solution {
    public List<Integer> partitionLabels(String s) {
        
        HashMap<Character,Integer> m = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
                m.put(ch,i);
        }
        List<Integer> ans = new ArrayList<>();
        int max=Integer.MIN_VALUE;
        int prev=-1;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
             max = Math.max(m.get(ch),max);    
            if(i==max){
                ans.add(i-prev);
                prev = i;
            }
        }
        return ans;
    }
}