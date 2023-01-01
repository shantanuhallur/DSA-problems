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
    public int findMinEleInRightSubtree(TreeNode node) {
        while(node.left!=null) node = node.left;
        return node.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        //Base Case
        if(root == null) return null;
        
        //binary search
        if(root.val < key) {
            //recurse to right side
            root.right = deleteNode(root.right,key);
        }
        else if(root.val > key) {
            root.left = deleteNode(root.left,key);
        }
        else{
            // Condition to handle both child null , right child null & left child null
            if(root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            }
            
            //if both children are present of node to be deleted
            //get min element in right subtree
            int minEle = findMinEleInRightSubtree(root.right);
            //as this element is min in our right subtree there is no chance that it will have 2 children or even 1 left child
            //substitute the val of min element in our current root.
            root.val = minEle;
            //delete the min element
            root.right = deleteNode(root.right,minEle);
        }
        return root;
    }
}