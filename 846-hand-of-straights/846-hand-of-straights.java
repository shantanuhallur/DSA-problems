class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //if(hand.length%groupSize!=0)return false;
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
      for(int card:hand){
          if(map.containsKey(card)){
              map.replace(card,map.get(card)+1);
          }
          else map.put(card,1);
      }
        
        while(!map.isEmpty()){
            int smallestCard = map.firstKey();
            for(int i=smallestCard ; i<smallestCard+groupSize;i++){
                if(!map.containsKey(i))return false;
                int count = map.get(i);
                if(count==1)map.remove(i);
                else map.replace(i,count-1);
            }
        }
        return true;
    }
}