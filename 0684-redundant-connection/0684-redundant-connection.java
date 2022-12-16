class Solution {
    int[] par;
    public int findParent(int u){
        return par[u] == -1 ? u : (par[u] = findParent(par[u])); 
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length; //V vertices have v-1 edges in spanning tree.
                                //V vertices + 1 edge = V edges in this tree.
        par = new int[N+1];
        Arrays.fill(par,-1); //as counting is started from 1 not 0;
        for(int[] edge : edges) {
            int p1 = findParent(edge[0]);
            int p2 = findParent(edge[1]);
            
            if(p1 != p2) {
                par[p1] = p2;
            }
            else return edge;
            
        }
        return new int[0];
    }
}