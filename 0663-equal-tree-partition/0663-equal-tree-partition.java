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
    List<Integer> subtreeSum;
    public int getTotal(TreeNode node) {
        if(node==null) return 0;
        int totalSum = node.val + getTotal(node.left) + getTotal(node.right);
        subtreeSum.add(totalSum);
        return totalSum;
    }

    public boolean checkEqualTree(TreeNode root) {
        subtreeSum = new ArrayList<>();
        int totalSum = getTotal(root);
        if(totalSum%2!=0) return false; // cannot be divided into equal 2 parts of Sum.
        //remove root
        subtreeSum.remove(subtreeSum.size()-1);
        return subtreeSum.contains(totalSum/2);
    }
}