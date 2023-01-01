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
    public int findMinInRight(TreeNode node) {
        
        while(node.left !=null) node = node.left;
        
        return node.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        TreeNode curr = root;        
    
            if(curr.val > key) {
                curr.left = deleteNode(curr.left,key);
            }
            else if(curr.val < key) {
                curr.right = deleteNode(curr.right,key);
            }
            else {
                if(curr.left == null || curr.right == null)
                    return curr.left == null? curr.right : curr.left; 
            
                int minEle = findMinInRight(curr.right);
                
                curr.val = minEle;
                
                curr. right = deleteNode(curr.right,minEle);
            }
        return curr;
    }
}