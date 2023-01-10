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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        //Base case if only val exists in b list.
        if(root == null) return new TreeNode(val);
        //when val is greater than the current subtree or whole trees root;
        if(root.val<val) return new TreeNode(val,root,null);        
        //recursive call to search the righjt position of val.
        root.right = insertIntoMaxTree(root.right,val);
        
        return root;
    }
}