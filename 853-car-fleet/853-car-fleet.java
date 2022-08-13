class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Car>pq = new PriorityQueue<>();
        for(int i=0;i<position.length;i++){
            Car c = new Car(position[i],speed[i]);
            
            pq.add(c);
        }
        int groups = 0;
        double time = 0;
        while(pq.size()>0){
            Car c = pq.remove();
            
            double dist = target - c.pos;
            double ctime = dist*1.0 / c.speed;
            
            if(ctime > time){
                time = ctime;
                groups++;
            }
        }
        return groups;
    }
    class Car implements Comparable<Car>{
        int pos;
        int speed;
        
        Car(int pos,int speed){
             this.pos = pos;
             this.speed = speed;
        }
        
        public int compareTo(Car c){
            return c.pos - this.pos;
        }
    }
}