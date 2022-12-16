class Solution {
    static int[] par;
    static int[] size;
    public static int findParent(int u) {
        return (par[u] == u ? u : (par[u] = findParent(par[u])));
    }
    
    public static void merge(int p1,int p2) {
        if(size[p1] > size[p2]) {
            par[p2] = p1;
            size[p1] += size[p2];
        }
        else {
            par[p1] = p2;
            size[p2] += size[p1];
        }

    }
    
    public static int[] unionFind(int N, int[][] Edges) {
        //@SuppressWarnings("unchecked");
        //ArrayList<Edge>[] graph = new ArrayList<>(N);
        //for(int i=0;i<N;i++) graph[i] = new ArrayList<>();

        par = new int[N+1]; //indexes start from 1 not 0
        size = new int[N];
        for(int i=0;i<N;i++) {
            size[i] = 1;
            par[i] = i;    
        }

        boolean cycle = false;
        for(int[] edge : Edges) {
            int u = edge[0], v = edge[1];
            int p1 = findParent(u);
            int p2 = findParent(v);

            if(p1 != p2){
                merge(p1, p2);
                //addEdge(graph, u, v, w);
            }
            else {
                cycle = true;
                int[] ansEdge = {u,v};
                return ansEdge;
            }
        }

        //display(N, graph);
        //System.out.println(cycle);
        return new int [0];
    }
    public int[] findRedundantConnection(int[][] edges) {
        return unionFind(edges.length,edges);
    }
}