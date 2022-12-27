class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];
        for(int i=0;i<n;i++) {
            if(leftChild[i]!=-1) {
                inDegree[leftChild[i]]++;
            }
            
            if(rightChild[i]!=-1) {
                inDegree[rightChild[i]]++;
            }
        }
        
        int root = -1;
        for(int i=0;i<n;i++) {
            if(inDegree[i]==0) {
                if(root==-1) root = i;
                else return false;
            }
        }
        if(root == -1) return false;
        //BFS
        HashSet<Integer> vis = new HashSet<>();
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(root);
        while(que.size()!=0) {
            Integer rn = que.removeFirst();
            if(!vis.add(rn)) return false;
            
            if(leftChild[rn]!=-1) que.addLast(leftChild[rn]);
            
            if(rightChild[rn]!=-1) que.addLast(rightChild[rn]);
        }
        
        
        return vis.size()==n;
    }
}