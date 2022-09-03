class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] seenTime = new boolean[60*24];
        
        for(String time : timePoints){
            String[] time_break = time.split(":");
            int hours = Integer.parseInt(time_break[0]);
            int mins = Integer.parseInt(time_break[1]);
            if(seenTime[(hours*60)+mins])return 0;
            seenTime[(hours*60)+mins] = true;
        }
        
        Integer first_time = null;
        Integer prev_time = null;
        Integer min_diff = Integer.MAX_VALUE;
        
        for(int i=0;i<seenTime.length;i++){
            if(seenTime[i]){
                if(first_time==null){
                    first_time = i;
                    prev_time = i;
                }
                else{
                    min_diff = Math.min(min_diff,Math.min(i- prev_time,1440 - i +                           prev_time));
                    prev_time = i;
                }
            }
        }
        min_diff = Math.min(min_diff,Math.min(prev_time - first_time,1440 - prev_time +                           first_time));
            
            return min_diff;
    }
}