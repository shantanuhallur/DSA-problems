class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(e1,e2)-> {
                return e1[1]-e2[1];
        });
        int count = 0 , i=0,n = pairs.length;
        while(i<n) {
            count++;
            int currEnd = pairs[i][1];
            while(i<n && pairs[i][0] <= currEnd) i++;
        }
        return count;
    }
}