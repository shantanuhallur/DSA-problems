class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       TreeMap<Integer,Integer>map = new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<position.length;i++){
            map.put(position[i],speed[i]);
        }
        
        double time = 0;
        int groups = 0;
        //position in decreasing order 
        for(Map.Entry<Integer,Integer> car : map.entrySet()){
            int pos = car.getKey();
            int spd = car.getValue();
            
            int dist = target - pos;
            double ctime = dist * 1.0 /spd;
            
            if(ctime > time){
                time = ctime;
                groups++;
            }
        }
        return groups;
    }
}