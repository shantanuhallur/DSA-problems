class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = {-100000,100000};
        int k = nums.size();
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<k;i++){
            int minOfList = nums.get(i).get(0); //first element of every list minimum
            int[] toBeAdded = {minOfList,0,i};
            //1st :- Minimum of list 
            //2nd :- idex of element added from the list
            //3rd :- index of list amongst all the lists
            max = Math.max(max,minOfList);
            pq.add(toBeAdded);
        }
        
        while(true){
            int[] min = pq.poll();
            if(res[1]-res[0]>max-min[0]){
                res[0] = min[0];
                res[1] = max;
            }
            min[1]++;
            List<Integer> cl = nums.get(min[2]);
            if(min[1]==cl.size()){
                break;
            }
            else{
                min[0] = cl.get(min[1]);
                max = Math.max(cl.get(min[1]),max);
                pq.add(min);
            }
        }
        
        return res;
    }
}