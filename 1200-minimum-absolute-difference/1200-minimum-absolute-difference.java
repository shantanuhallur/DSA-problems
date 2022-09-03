class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        
        List<List<Integer>> res = new ArrayList<>();
        int min_dif = Integer.MAX_VALUE;
        
        for(int i=1;i<arr.length;i++){
            min_dif = Math.min(min_dif,arr[i]-arr[i-1]);
        }
        
         for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1] == min_dif){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                res.add(temp);
            }
        }
        return res;
    }
}