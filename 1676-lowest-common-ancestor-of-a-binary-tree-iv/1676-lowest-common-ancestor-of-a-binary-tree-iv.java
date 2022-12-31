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
    TreeNode lcA = null;
     public int lca(TreeNode node, HashSet<Integer> set) {
        if(node == null) return 0;
         
         int leftCont = lca(node.left,set);
         int rightCount = lca(node.right,set);
         
         int foundCount = leftCont+rightCount;
         if(set.contains(node.val)) foundCount++;
         
         if(lcA==null && foundCount == set.size()) lcA = node;
         
         return foundCount;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> set = new HashSet<>();
        for(TreeNode node : nodes) {
            set.add(node.val);
        }
        lca(root,set);
        return lcA;
    }
}