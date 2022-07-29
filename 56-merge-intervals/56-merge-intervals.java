class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{return a[0]-b[0];});
        
        ArrayList<int[]> list = new ArrayList<>();
        
       for(int[] interval:intervals){
           if(list.size()==0){
               list.add(interval);
           }
           else{
               int[] li = list.get(list.size()-1);
               if(interval[0]>li[1]){
                   list.add(interval);
               }
               else{
                 //keep the starting point same , change ending p(t[1]) to maximum of both's ending pt.
                    li[1] = Math.max(li[1],interval[1]);
               }
           }
       }
        return list.toArray(new int[list.size()][2]);
    }
}