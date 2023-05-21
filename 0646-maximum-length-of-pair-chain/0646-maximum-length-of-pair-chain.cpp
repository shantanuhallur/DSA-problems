class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(e1,e2)-> {
                return e1[1]-e2[1];
        });
        int curr = -1001;
        int ans = 0;
        for(int i = 0;i<pairs.length;i++) {
            if(pairs[i][0]> curr) {
               curr = pairs[i][1];
                ans++;
            }
        }
        return ans;
    }
}