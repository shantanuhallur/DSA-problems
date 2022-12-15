class Solution {
            public ArrayList<Integer> kahnsAlgo (int N,  List<List<Integer>> graph) {
        int[] inDegree = new int[N];
        for(int i=0;i<N;i++) {
            for(int e : graph.get(i)){
                inDegree[e]++;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<Integer> que = new LinkedList<>();

        for(int i=0;i<N;i++) {
            if(inDegree[i]==0){
                que.add(i);
            }
        }
        int level = 0;
        while(que.size()>0) {
            int size = que.size();
            while(size-- >0){
                int rvtx = que.removeFirst();
                ans.add(rvtx);

                for(int e : graph.get(rvtx)) {
                    // inDegree[e.v]--;
                    if(--inDegree[e]==0) {
                        que.add(e);
                    } 
                }
            }
            level++;
        }

        return ans;
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] arr:prerequisites) {
            int start = arr[0];
            int end = arr[1];

            graph.get(start).add(end); 
        }
        ArrayList<Integer> ans = kahnsAlgo(numCourses,graph);
        if(ans.size() != numCourses) return new int[0];
        Collections.reverse(ans);
        int[] Rans = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            Rans[i] = ans.get(i);
    }
        
        return Rans;
}
}