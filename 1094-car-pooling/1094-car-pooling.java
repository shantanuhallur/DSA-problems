class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer,Integer> tmap = new TreeMap<>();
        
        for(int[] trip:trips){
            tmap.put(trip[1],tmap.getOrDefault(trip[1],0)+trip[0]);
            tmap.put(trip[2],tmap.getOrDefault(trip[2],0)-trip[0]);
            
        }
        
        for(int val: tmap.values()){
             capacity-=val;
            if(capacity<0){
                return false;
            }
        }
        return true;
    }
}