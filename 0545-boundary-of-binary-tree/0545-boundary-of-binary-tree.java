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
    public void formLeftBoundary(TreeNode node,List<Integer> res) {
        if(node==null) return;
        if(node.left!=null) {
            res.add(node.val);
            formLeftBoundary(node.left,res);
        }
        else if(node.right != null) {
            res.add(node.val);
            formLeftBoundary(node.right,res);
        }
    }
    
    public void formRightBoundary(TreeNode node,List<Integer> res) {
        if(node==null) return;
        if(node.right!=null) {
            formRightBoundary(node.right,res);
            res.add(node.val);
        }
        else if(node.left!=null) {
            formRightBoundary(node.left,res);
            res.add(node.val);
        }
    }
    public void addLeaves(TreeNode node,List<Integer> res) {
        if(node==null) return;
        addLeaves(node.left,res);
        if(node.left==null && node.right == null)res.add(node.val);
        addLeaves(node.right,res);
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        res.add(root.val);
        formLeftBoundary(root.left,res);
        addLeaves(root.left,res);
        addLeaves(root.right,res);
        formRightBoundary(root.right,res);
        return res;
    }
}