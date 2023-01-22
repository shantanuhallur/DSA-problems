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
    public TreeNode dfs(TreeNode node,int k,HashMap<TreeNode,TreeNode> backMap) {
        if(node.val == k) return node;
        
        if(node.left!=null) {
            backMap.put(node.left,node);
            TreeNode left = dfs(node.left,k,backMap);
            if(left!=null) return left;
        }
        
        if(node.right!=null) {
            backMap.put(node.right,node);
            TreeNode right = dfs(node.right,k,backMap);
            if(right!=null) return right;
        }
        
        return null;
    }
    
    public int findClosestLeaf(TreeNode root, int k) {
        HashMap<TreeNode,TreeNode> backMap = new HashMap<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        HashSet<TreeNode> vis = new HashSet<>();
        
        TreeNode kN = dfs(root,k,backMap);
        que.addLast(kN);
        vis.add(kN);
        while(que.size()!=0) {
            TreeNode removeN = que.removeFirst();
            if(removeN.left == null & removeN.right == null) {
                return removeN.val;
            }
            
            if(removeN.left != null &&  vis.add(removeN.left)) {
                    que.addLast(removeN.left);
            }
            
            if(removeN.right != null && vis.add(removeN.right)) {
                que.addLast(removeN.right);
            }
            
            if(backMap.containsKey(removeN) && vis.add(backMap.get(removeN))) {
                que.addLast(backMap.get(removeN));
            }
        }
        return -1;
    }
}