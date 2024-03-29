class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==0){
            return new int[k];
        }
     HashMap<Integer,Integer> m = new HashMap<>();
        for(int num:nums){
            m.put(num,m.getOrDefault(num,0)+1);
        }
        //MIN priority queue on the basis of FREQUENCY of MAP; 
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)-> m.get(a)- m.get(b));
        //keep pq of size K so that we get only elements with greatest freq
        for(int value: m.keySet()){
            pq.add(value);
            if(pq.size()>k){
                pq.poll();
            }
        }
        //store answer from pq in res array.
        int[] res = new int[k];
        int ptr=0;
        while(!pq.isEmpty()){
            int val = pq.poll();
            res[ptr++] = val;
        }
        //return res.
        return res;
    }
}