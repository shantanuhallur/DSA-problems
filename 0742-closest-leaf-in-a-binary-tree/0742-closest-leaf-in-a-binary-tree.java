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
    public TreeNode dfs(TreeNode node,HashMap<Integer,TreeNode>bm,int target) {
        if(node==null) return null;
        if(target==node.val) {
            return node;
        }
        TreeNode left = dfs(node.left,bm,target);
        if(left != null) {
            bm.put(node.left.val,node);
            return left;
        }
        TreeNode right = dfs(node.right,bm,target);
        if(right != null) {
            bm.put(node.right.val,node);
            return right;
        }
        return null;
    }
    public int findClosestLeaf(TreeNode root, int k) {
        if(root.left==null && root.right==null) return root.val;
        HashMap<Integer,TreeNode> bm = new HashMap<Integer,TreeNode>();
        LinkedList<TreeNode> que = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        TreeNode start = dfs(root,bm,k);
        que.addLast(start);
        System.out.print(start.val);
        while(que.size()!=0) {
            int size = que.size();
            while(size-->0) {
                TreeNode rn = que.removeFirst();
                if(rn.left == null && rn.right == null) {
                    return rn.val;
                }
                if(rn.left!=null && vis.add(rn.left.val)) {
                    que.addLast(rn.left);
                    
                }
                if(rn.right!=null && vis.add(rn.right.val)) {
                    que.addLast(rn.right);
                }
                
                if(bm.containsKey(rn.val) && vis.add(bm.get(rn.val).val)) {
                    que.addLast(bm.get(rn.val));
                }
            }
        }
       return -1; 
    }
}