class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==0){
            return new int[k];
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(int n:map.keySet()){
            pq.add(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
                                                       
        int[] res = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            int num = pq.poll();
            res[i++] = num;
        }
       return res;
    }
}