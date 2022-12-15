class Solution {
            public LinkedList<Integer> kahnsAlgo (int N,  List<List<Integer>> graph) {
        int[] inDegree = new int[N];
        for(int i=0;i<N;i++) {
            for(int e : graph.get(i)){
                inDegree[e]++;
            }
        }

        LinkedList<Integer> ans = new LinkedList<>();
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
                ans.addLast(rvtx);

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
        LinkedList<Integer> ans = kahnsAlgo(numCourses,graph);
        if(ans.size() != numCourses) return new int[0];
        int[] Rans = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            Rans[i] = ans.removeLast();
    }
        
        return Rans;
}
}