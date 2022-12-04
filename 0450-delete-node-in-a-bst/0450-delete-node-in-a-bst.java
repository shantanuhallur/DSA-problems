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
    public static int maxEle(TreeNode root) {
        TreeNode curr = root;

        while (curr.right != null) {
            curr = curr.right;
        }

        return curr.val;
    }
    
    
    public static int minEle(TreeNode root) {
        TreeNode curr = root;

        while (curr.left != null) {
            curr = curr.left;
        }

        return curr.val;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            }

            int minValue = minEle(root.right); // get max from left or min from right the node to delete will                                                    always
            root.val = minValue; // be a leaf or one with 1 subtree only never a node with 2 subtrees
                                 // as it will then not be the max or min node of that subtree.
            root.right = deleteNode(root.right, minValue);
        }

        return root;
    }
}