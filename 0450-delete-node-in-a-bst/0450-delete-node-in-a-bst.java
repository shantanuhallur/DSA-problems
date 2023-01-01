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
    public int findMin(TreeNode node) {
        
        while(node.left != null) node = node.left;
        return node.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(root.val < key) {
            root.right = deleteNode(root.right,key);
        }
        else if(root.val > key) {
            root.left = deleteNode(root.left,key);
        }
        else {
            if(root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            }
            //if both children nodes exist
            int minEle = findMin(root.right);
            root.val = minEle;
            root.right = deleteNode(root.right,minEle);
        }
        return root;
    }
}