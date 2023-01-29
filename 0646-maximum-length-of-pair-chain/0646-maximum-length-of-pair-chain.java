class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(e1,e2)-> {
                return e1[0]-e2[0];
        });
        int longestChain = 1;
        int n = pairs.length;
        int[] lis = new int[n];
        for(int i =0;i<n;i++) {
            lis[i] = 1;
            for(int j=0;j<i;j++) {
                if(pairs[j][1]<pairs[i][0] && lis[j]+1>lis[i]) {
                    lis[i] = lis[j]+1;
                    longestChain = Math.max(lis[i],longestChain);
                }
            }
        }
        return longestChain;
    }
}