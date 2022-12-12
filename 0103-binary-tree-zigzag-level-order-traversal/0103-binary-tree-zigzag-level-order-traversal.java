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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> ans = new LinkedList<>();
        int lvl = 1;
        while(q.size()!=0) {
            int size = q.size();
            LinkedList<Integer> smallAns = new LinkedList<>();
            while(size-->0) {
                TreeNode rn = q.removeFirst();
                if(rn.left!=null) {
                    q.addLast(rn.left);
                }
                if(rn.right!=null) {
                    q.addLast(rn.right);
                }
                
                if(lvl%2==0) {
                    smallAns.addFirst(rn.val);
                }
                else{
                    smallAns.addLast(rn.val);
                }
            }
            ans.add(new LinkedList<>(smallAns));
            lvl++;
        }
        
        return ans;
    }
}