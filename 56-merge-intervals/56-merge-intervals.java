class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{return a[0]-b[0];});
        
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int i=0;i<intervals.length;i++){
            if(list.size()==0){
                list.add(intervals[i]);
            }
            else{
                 int[] top = list.get(list.size()-1);
                if(top[1]<intervals[i][0]){
                    list.add(intervals[i]);
                }
                else{
                    top[1] = Math.max(top[1],intervals[i][1]);
                }
            }
        }
        int[][]res = new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}