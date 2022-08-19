class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
       for(int card:hand){
           if(!map.containsKey(card)){
               map.put(card,1);
           }
           else{
               map.put(card,map.get(card)+1);
           }
       }
        
        while(map.size()>0){
            int FrstCrd = map.firstKey();
            
            for(int i=FrstCrd;i<FrstCrd+groupSize;i++){
                if(!map.containsKey(i))return false;
                int countOfCards = map.get(i);
                
                if(countOfCards==1){
                    map.remove(i);
                }
                else{
                    map.replace(i,countOfCards-1);
                }
            }
        }
        return true;
    }
}