class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int i=0;
        ArrayList<int[]> list = new ArrayList<>();
        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        int[] interval = newInterval;
        while(i<intervals.length && intervals[i][0] <= interval[1]){
            interval[0] = Math.min(intervals[i][0],interval[0]);
            interval[1] = Math.max(intervals[i][1],interval[1]);
            i++;
        }
        list.add(interval);
        
        while(i<intervals.length){
            list.add(intervals[i]);
            i++;
        }
        
        return list.toArray(new int[list.size()][1]);
    }
}