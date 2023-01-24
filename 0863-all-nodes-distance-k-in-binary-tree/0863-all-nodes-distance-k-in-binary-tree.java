/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode dfs(TreeNode node,TreeNode target,HashMap<TreeNode,TreeNode> bm) {
        if(node==null) return null;
        if(node.val == target.val) return node;
        //left right recur calls
        TreeNode left = dfs(node.left,target,bm);
        if(left != null) {
            //contruct backmap
            bm.put(node.left,node);
            return left;
        }
        TreeNode right = dfs(node.right,target,bm);
        if(right!=null) {
            bm.put(node.right,node);
            return right;
        }
        return null;
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> bm = new HashMap<>();
        //dfs will give us the target node
        TreeNode start = dfs(root,target,bm);
        System.out.print(start.val);
        HashSet<TreeNode> vis =new HashSet<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        //bfs for k levels
        que.add(start);
        while(k-->0){
            int size = que.size();
                while(size-->0) {
                    TreeNode rn = que.removeFirst();
                    
                    if(rn.left != null  && vis.add(rn.left)) {
                        que.addLast(rn.left);
                    }
                    
                    if(rn.right != null && vis.add(rn.right)) {
                        que.addLast(rn.right);
                    }
                    //check for parent if exists add in que
                    if(bm.containsKey(rn) && vis.add(rn)) {
                        que.add(bm.get(rn));
                    }
                    
                }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(TreeNode node : que) {
            ans.add(node.val);
        }
        return ans;
    }
}