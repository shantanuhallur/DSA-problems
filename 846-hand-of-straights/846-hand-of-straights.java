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
            int firstCard = map.firstKey();
            for(int i=firstCard ; i<firstCard + groupSize ;i++){
                if(!map.containsKey(i))return false;
                int count = map.get(i);
                if(count==1){
                    map.remove(i);
                }
                else{
                    map.replace(i,count-1);
                }
            }
        }
        return true;
    }
}