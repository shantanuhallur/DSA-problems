class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] arr = s.toCharArray();
        HashMap<Character,Integer> m = new HashMap<>();
        for(int i=0;i<arr.length;i++){
                m.put(arr[i],i);
        }
        List<Integer> ans = new ArrayList<>();
        int max=Integer.MIN_VALUE;
        int prev=-1;
        for(int i=0;i<arr.length;i++){
             max = Math.max(m.get(arr[i]),max);    
            if(i==max){
                ans.add(i-prev);
                prev = i;
            }
        }
        return ans;
    }
}