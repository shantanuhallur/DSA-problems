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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode base = new TreeNode(val);
            base.left = root;
            return base;
        }
        
        int level = 1;
        
        LinkedList<TreeNode> que = new LinkedList<>();
        
        que.addLast(root);
        
        while(level < depth-1) {
            int size = que.size();
            while(size-- >0) {
                TreeNode rn = que.removeFirst();
                
                if(rn.left != null) {
                    que.addLast(rn.left);
                }
                
                if(rn.right != null) {
                    que.addLast(rn.right);
                }
            }
            level++;
        }
        
        while(que.size() != 0) {
            TreeNode rn = que.removeFirst();
            
                TreeNode temp1 = rn.left;
                TreeNode temp2 = rn.right;
                rn.left = new TreeNode(val);
                rn.right = new TreeNode(val);
                rn.left.left = temp1;
                rn.right.right = temp2;
            }
            
        return root;
    }
}
