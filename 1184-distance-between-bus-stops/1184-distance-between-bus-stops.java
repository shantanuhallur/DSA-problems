class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int s = start<destination?start:destination;
        int e = start<destination?destination:start;
        int totalDist=0;
        int clockWiseDist = 0;
        for(int i=0;i<distance.length;i++){
            if(i>=s && i< e){
                clockWiseDist+=distance[i];
            }
            totalDist += distance[i];
        }
        
        return Math.min(clockWiseDist,totalDist-clockWiseDist);
    }
}