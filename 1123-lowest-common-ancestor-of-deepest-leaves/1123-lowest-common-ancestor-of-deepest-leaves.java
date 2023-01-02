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
    public int height(TreeNode node) {
        //Base Case
        if(node==null) return 0;
        //Left recursive call of Faith
        int leftH = height(node.left);
        
        //right recursive faith of call
        int rightH = height(node.right);
        //calculate height of current node
        return Math.max(leftH,rightH) + 1;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        //base case 
        if(root == null) return null;
        
        //get left & right Subtree's height
        int leftSubtreeH = height(root.left);
        int rightSubtreeH = height(root.right);
        
        //check whichever height is max we have our lca on that side of our root
        if(leftSubtreeH == rightSubtreeH) return root;
        else if(leftSubtreeH < rightSubtreeH) {
            return lcaDeepestLeaves(root.right);
        }
        else{//we will eget LCA in left side
            return lcaDeepestLeaves(root.left);
        }
        
    }
}