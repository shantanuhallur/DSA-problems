class Solution {
    
    public class Pair{
        char c;
        int f;
        Pair(char c , int f){
            this.c = c;
            this.f = f;
        }
    }
    public String reorganizeString(String s) {
        int[] map = new int[26];
        //create freq map for char in string s
        for(int i=0;i<s.length();i++){
            map[s.charAt(i)-'a']++;
        }
        //Max freq priority Q.
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(b.f-a.f));
        //add chars in map
        for(int i=0;i<map.length;i++){
            if(map[i]>0){
                pq.add(new Pair((char)(i+'a'),map[i]));
            }
        }
        
        StringBuilder ans = new StringBuilder();
        Pair block = pq.poll();
        ans.append(block.c);
        block.f--;
        while(pq.size()>0){
            Pair temp = pq.poll();
            ans.append(temp.c);
            temp.f--;
            if(block.f>0){
                 pq.add(block);
            }
           
            block = temp;
        }
        //Case when answer doesnt exit .. my block is not empty.
        if(block.f>0){
            return "";
        }
        return ans.toString();
        
    }
}