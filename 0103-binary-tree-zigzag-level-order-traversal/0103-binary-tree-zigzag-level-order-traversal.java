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
        List<List<Integer>> ans = new ArrayList<>();
        int lvl = 1;
        while(q.size()!=0) {
            int size = q.size();
            List<Integer> smallAns = new ArrayList<>();
            while(size-->0) {
                TreeNode rn = q.removeFirst();
                if(rn.left!=null) {
                    q.addLast(rn.left);
                }
                if(rn.right!=null) {
                    q.addLast(rn.right);
                }
                
                
                if(lvl%2==0) {
                    smallAns.add(0,rn.val);
                }
                else{
                    smallAns.add(rn.val);
                }
            }
            ans.add(new ArrayList<>(smallAns));
            lvl++;
        }
        
        return ans;
    }
}