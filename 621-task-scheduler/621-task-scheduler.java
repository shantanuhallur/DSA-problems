class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] char_map = new int[26];
        for(char ch:tasks){
            char_map[ch-'A']++;
        }
        
        Arrays.sort(char_map);
        int max_val = char_map[25]-1; //-1 because we dont care if they are at end we dont                              have to fill them as we have already finished all tasks.
        int idle_slot = max_val*n;
        for(int i=24;i>=0;i--){
            idle_slot -= Math.min(char_map[i],max_val); //filling up all tasks evenly in                                            idle spots greedyly.
        }
        
        return idle_slot >0 ? idle_slot + tasks.length : tasks.length;
    }
}