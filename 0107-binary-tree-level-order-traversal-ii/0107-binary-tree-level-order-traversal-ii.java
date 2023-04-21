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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) return new LinkedList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        
        List<List<Integer>> ans = new LinkedList<>();
        que.addLast(root);
        
        while(que.size()>0) {
            int size = que.size();
            LinkedList<Integer> levelAns = new LinkedList<>();
            while(size-->0) {
                TreeNode rn = que.removeFirst();
                
                if(rn.left!=null) {
                    que.addLast(rn.left);
                }
                
                if(rn.right!=null) {
                    que.addLast(rn.right);
                }
                
                levelAns.addLast(rn.val);
            }
            ans.add(0,levelAns);
        }
        return ans;
    }
}