/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        void fillGraph(TreeNode node,ArrayList<Integer>[] graph) {
        if(node==null) return;
        
        if(node.left!=null) {
             graph[node.val].add(node.left.val);
            graph[node.left.val].add(node.val);
        }
        if(node.right != null) {
            graph[node.val].add(node.right.val);
            graph[node.right.val].add(node.val);
        }
        
        fillGraph(node.left,graph);
        fillGraph(node.right,graph);
    }
    
    int bfs(ArrayList<Integer>[] graph,int start) {
        boolean[] vis = new boolean[100001];
        int ans = 0;
        LinkedList<Integer> que = new LinkedList<>();  
        que.addLast(start);
        
        while(que.size()!=0) {
            int size = que.size();
            while(size-->0) {
                int removeN = que.removeFirst();
                vis[removeN] = true;
                for(int i=0;i<graph[removeN].size();i++) {
                    if(!vis[graph[removeN].get(i)]) {
                        que.addLast(graph[removeN].get(i));
                    }
                }        
            }
                ans++;
        }
        return ans;
    }
        
        public int amountOfTime(TreeNode root, int start) {
            ArrayList<Integer>[] graph = new ArrayList[100001];
            for(int i=0;i<100001;i++) {
                graph[i] = new ArrayList<>();
            }
            fillGraph(root,graph);

            return bfs(graph,start)-1;
        }
}