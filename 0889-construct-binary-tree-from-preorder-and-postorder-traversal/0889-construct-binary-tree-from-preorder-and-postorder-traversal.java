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
    int preIdx = 0;
    int postIdx = 0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        //Root creation
        TreeNode root = new TreeNode(pre[preIdx++]);
        //checking if that part of tree is completed if not then recursivly calling L & R.
        if(root.val != post[postIdx]) {
           root.left = constructFromPrePost(pre,post);
        }
        
        if( root.val != post[postIdx]) {
            root.right = constructFromPrePost(pre,post);
        }
        //if both of the above functions are false means our tree is alredy created return root.
        postIdx++;
        return root;
    }
}