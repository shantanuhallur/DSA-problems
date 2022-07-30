class Solution {
    public int findMinArrowShots(int[][] points) {
        //Comparator for Arrays.
        Arrays.sort(points,(a,b)->{
            if(a[0]>b[0]){
                return 1;
            }
            else if(a[0]==b[0]){
                return 0;
            }
            else{
                return -1;
            }
        });
        
        int count = 0;
        int end = Integer.MIN_VALUE;
        for(int[] p:points){
            System.out.print(p[0]+" end "+end+" Count "+count+" ");
            if(p[0]>end){
                count++;
// if new balloon starts after current baloon's end we need new arrow. update end to end of new baloon
                end = p[1];
            }
            else{
//else we pick out the min of next and current arrow's range. 29th July FJP 2022.
                end = Math.min(end,p[1]);
            }
        }
        return (count==0?1:count);
    }
}