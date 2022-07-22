class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer,Integer> m = new TreeMap<>();
        
        for(int[] trip:trips){
            m.put(trip[1],m.getOrDefault(trip[1],0)+trip[0]);
            m.put(trip[2],m.getOrDefault(trip[2],0)-trip[0]);
        }
        
        for(int sitter:m.values()){
            capacity -= sitter;
            if(capacity<0){
                return false;
            }
        }
        return true;
    }
}