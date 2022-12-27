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
   
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new LinkedList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        while(que.size()!=0) {
            int size = que.size();
            while(size-->0) {
                TreeNode rn = que.removeFirst();
                
                if(rn.left!=null) {
                    que.add(rn.left);
                }
                
                if(rn.right!=null) {
                    que.add(rn.right);
                }
                
                if(size==0) ans.add(rn.val);
            }
        }
        return ans;
    }
}